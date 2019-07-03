package org.hispci.enterprisemanager.repositories.persons;

import org.hispci.enterprisemanager.domain.persons.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonNameRepository extends JpaRepository<PersonName, Long> {
    List<PersonName> findByGivenNameContainingOrFamilyNameContaining(String givenName, String familyName);
    List<PersonName> findByFamilyNameContaining(String familyName);
}
