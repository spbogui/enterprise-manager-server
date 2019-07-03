package org.hispci.enterprisemanager.services.persons;

import org.hispci.enterprisemanager.domain.persons.Person;
import org.hispci.enterprisemanager.domain.persons.PersonName;
import org.hispci.enterprisemanager.repositories.persons.PersonAddressRepository;
import org.hispci.enterprisemanager.repositories.persons.PersonNameRepository;
import org.hispci.enterprisemanager.repositories.persons.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin("*")
public class PersonRestServiceResource {
    private final PersonRepository personRepository;
    private final PersonNameRepository personNameRepository;
    private final PersonAddressRepository personAddressRepository;

    public PersonRestServiceResource(PersonRepository personRepository, PersonNameRepository personNameRepository,
                                     PersonAddressRepository personAddressRepository) {
        this.personRepository = personRepository;
        this.personNameRepository = personNameRepository;
        this.personAddressRepository = personAddressRepository;
    }

    /**
     * createPerson()
     * @param person
     * @return Person
     */
    @PostMapping
    @ResponseBody
    public Person createPerson(@RequestBody Person person) {
        person.getPersonAddress().setPerson(person);
        person.getPersonName().setPerson(person);
        return personRepository.save(person);
    }

    /**
     * updatePerson()
     * @param person
     * @return Person
     */
    @PutMapping
    @ResponseBody
    public Person updatePerson(@RequestBody Person person) {
        return personRepository.saveAndFlush(person);
    }

    /**
     * deletePerson()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean deletePerson(@PathVariable Long id) {
        Optional<Person> result = personRepository.findById(id);

        if (result.isPresent()) {
            personRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAllActivities()
     * @return List<Person>
     */
    @GetMapping("/all")
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    /**
     * findAllPersonsByRetire()
     * @return List<Person>
     */
    @GetMapping
    public List<Person> findPersons() {
        return personRepository.findByRetired(false);
    }

    /**
     * getPerson()
     * @param id
     * @return Person
     */
    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id){
        return personRepository.findById(id).orElse(null);
    }

    /**
     * findByUuid()
     * @param uuid
     * @return Person
     */
    @GetMapping("/uuid/{uuid}")
    public Person findPersonByUuid(@PathVariable String uuid) {
        return personRepository.findByUuid(uuid);
    }

    @GetMapping("/name/{name}")
    public List<Person> findByName(@PathVariable String name) {
        List<PersonName> personNames = personNameRepository.findByGivenNameContainingOrFamilyNameContaining(name, name);
        List<Person> result = new ArrayList<>();

        personNames.forEach(personName -> {
            result.add(personName.getPerson());
        });
        return result;
    }
}
