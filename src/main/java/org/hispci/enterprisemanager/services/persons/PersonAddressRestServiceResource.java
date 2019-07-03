package org.hispci.enterprisemanager.services.persons;

import org.hispci.enterprisemanager.domain.persons.PersonAddress;
import org.hispci.enterprisemanager.repositories.persons.PersonAddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/person-addresses")
@CrossOrigin("*")
public class PersonAddressRestServiceResource {
    private final PersonAddressRepository personAddressRepository;

    public PersonAddressRestServiceResource(PersonAddressRepository personAddressRepository) {
        this.personAddressRepository = personAddressRepository;
    }

    /**
     * createPerson()
     * @param personAddress
     * @return Person
     */
    @PostMapping
    @ResponseBody
    public PersonAddress create(@RequestBody PersonAddress personAddress) {
        return personAddressRepository.save(personAddress);
    }

    /**
     * updatePerson()
     * @param personAddress
     * @return Person
     */
    @PutMapping
    @ResponseBody
    public PersonAddress update(@RequestBody PersonAddress personAddress) {
        return personAddressRepository.saveAndFlush(personAddress);
    }

    /**
     * deletePerson()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<PersonAddress> result = personAddressRepository.findById(id);

        if (result.isPresent()) {
            personAddressRepository.deleteById(id);
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
    public PersonAddress findById(@PathVariable Long id){
        return personAddressRepository.findById(id).orElse(null);
    }
}
