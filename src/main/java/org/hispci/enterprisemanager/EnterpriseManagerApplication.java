package org.hispci.enterprisemanager;

import com.github.javafaker.Faker;
import org.hispci.enterprisemanager.domain.employment.contracts.Contract;
import org.hispci.enterprisemanager.domain.employment.contracts.ContractType;
import org.hispci.enterprisemanager.domain.employment.employees.*;
import org.hispci.enterprisemanager.domain.persons.Person;
import org.hispci.enterprisemanager.domain.persons.PersonAddress;
import org.hispci.enterprisemanager.domain.persons.PersonName;
import org.hispci.enterprisemanager.repositories.employments.contracts.ContractRepository;
import org.hispci.enterprisemanager.repositories.employments.contracts.ContractTypeRepository;
import org.hispci.enterprisemanager.repositories.employments.employees.*;
import org.hispci.enterprisemanager.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class EnterpriseManagerApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private LevelRepository levelRepository;
	@Autowired
	private ContractTypeRepository contractTypeRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private HierarchyRepository hierarchyRepository;
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	StaffIdentifierRepository staffIdentifierRepository;
	@Autowired
	StaffPostRepository staffPostRepository;
	@Autowired
	IdentifierTypeRepository identifierTypeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("fr"));
		int maxPerson = 30;
		for (int i = 0; i < maxPerson; i++) {
			Person person = new Person();
			person.setRetired(faker.random().nextBoolean());
			person.setGender(faker.demographic().sex());
			person.setBirthPlace(faker.address().cityName());
			person.setBirthDate(faker.date().birthday());
			person.setPersonName(new PersonName(person, faker.name().lastName(), faker.name().firstName()));
			person.setPersonAddress(new PersonAddress(person, faker.address().fullAddress(), faker.phoneNumber().cellPhone()));
			personRepository.save(person);
		}

		for (int i= 0; i < 30; i++) {
			Job job = new Job();
			String name = faker.job().position();
			if (jobRepository.findByName(name) == null) {
				job.setName(name);
				jobRepository.save(job);
			}
		}

		for (int i = 0; i < 40; i++) {
			Post post = new Post();
			String name = faker.job().title();
			if (postRepository.findByName(name) == null) {
				post.setName(name);
				post.setNumberAvailable(faker.number().numberBetween(1, 10));
				postRepository.save(post);
			}
		}

		Level direction = new Level("Direction");
		Level sousDirection = new Level("Sous-Direction");
		Level service = new Level("Service");

		sousDirection.setParentLevel(levelRepository.save(direction));
		service.setParentLevel(levelRepository.save(sousDirection));
		levelRepository.save(service);

		contractTypeRepository.save(new ContractType("Contrat à Durée Déterminée", 0));
		contractTypeRepository.save(new ContractType("Contrat à Durée Indéterminée", 180));
		contractTypeRepository.save(new ContractType("Stage de Perfectionnement", 90));
		contractTypeRepository.save(new ContractType("Stage de Pré-Emploi", 90));

		gradeRepository.save(new Grade("A1"));
		gradeRepository.save(new Grade("A2"));
		gradeRepository.save(new Grade("A3"));

		Hierarchy hierarchy = new Hierarchy("Direction Technique");
		hierarchy.setLevel(levelRepository.findByName("Direction"));
		hierarchyRepository.save(hierarchy);

		Post post = new Post("Directeur Technique");
		post.setHierarchy(hierarchy);
		postRepository.save(post);

		Job job = new Job("Informaticien Développeur");
		jobRepository.save(job);

		Person person = new Person();
		person.setRetired(faker.random().nextBoolean());
		person.setGender(faker.demographic().sex());
		person.setBirthDate(faker.date().birthday());
		person.setPersonName(new PersonName(person, faker.name().lastName(), faker.name().firstName()));
		person.setPersonAddress(new PersonAddress(person, faker.address().fullAddress(), faker.phoneNumber().cellPhone()));

		Staff staff = new Staff();
		//staff.getContracts().add();
		staff.setJob(job);
		staff.setPerson(person);
		staff.setGrade(gradeRepository.findByName("A1"));

		staffRepository.save(staff);

		Contract contract = new Contract();
		contract.setContractType(contractTypeRepository.findByName("Contrat à Durée Déterminée"));
		contract.setSignedDate(new Date());
		contract.setStartDate(new Date());
		contract.setStaff(staff);
		contractRepository.save(contract);

		StaffPost staffPost = new StaffPost();
		staffPost.setActual(true);
		staffPost.setStartDate(new Date());
		staffPost.setPost(post);
		staffPost.setStaff(staff);
		staffPostRepository.save(staffPost);

		StaffIdentifier staffIdentifier = new StaffIdentifier();
		staffIdentifier.setIdentifierType(identifierTypeRepository.save(new IdentifierType("Matricule")));
		staffIdentifier.setPreferred(true);
		staffIdentifier.setIdentifier("AAAAA99999");
		staffIdentifier.setStaff(staff);
		staffIdentifierRepository.save(staffIdentifier);
	}
}
