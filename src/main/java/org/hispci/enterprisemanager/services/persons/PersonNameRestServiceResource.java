package org.hispci.enterprisemanager.services.persons;

import org.hispci.enterprisemanager.domain.persons.Person;
import org.hispci.enterprisemanager.domain.persons.PersonName;
import org.hispci.enterprisemanager.repositories.persons.PersonNameRepository;
import org.hispci.enterprisemanager.repositories.persons.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/person-names")
@CrossOrigin("*")
public class PersonNameRestServiceResource {
    private final PersonNameRepository personNameRepository;
    private final PersonRepository personRepository;

    public PersonNameRestServiceResource(PersonNameRepository personNameRepository, PersonRepository personRepository) {
        this.personNameRepository = personNameRepository;
        this.personRepository = personRepository;
    }

    /**
     * createPerson()
     * @param personName
     * @return Person
     */
    @PostMapping
    @ResponseBody
    public PersonName create(@RequestBody PersonName personName) {
        Long id = personName.getId();
        Person p = personRepository.findById(id).orElse(null);
        if (p != null) {
            personName.setPerson(p);
            System.out.println(personName.toString());
            return personNameRepository.save(personName);
        }
        return null;
    }

    /**
     * updatePerson()
     * @param personName
     * @return Person
     */
    @PutMapping
    @ResponseBody
    public PersonName update(@RequestBody PersonName personName) {
        return personNameRepository.saveAndFlush(personName);
    }

    /**
     * deletePerson()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<PersonName> result = personNameRepository.findById(id);

        if (result.isPresent()) {
            personNameRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * getPerson()
     * @param id
     * @return Person
     */
    @GetMapping("/{id}")
    public PersonName findById(@PathVariable Long id){
        return personNameRepository.findById(id).orElse(null);
    }
}
