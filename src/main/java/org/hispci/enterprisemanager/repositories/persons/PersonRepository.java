package org.hispci.enterprisemanager.repositories.persons;

import org.hispci.enterprisemanager.domain.persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
    @RestResource(path = "/uuid/{uuid}")
    Person findByUuid(@PathVariable("uuid") String uuid);
    List<Person> findByRetired(Boolean retired);
}
