package org.hispci.enterprisemanager.repositories.persons;

import org.hispci.enterprisemanager.domain.persons.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
}
