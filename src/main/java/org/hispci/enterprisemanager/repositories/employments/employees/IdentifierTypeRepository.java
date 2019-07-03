package org.hispci.enterprisemanager.repositories.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.IdentifierType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IdentifierTypeRepository extends JpaRepository<IdentifierType, Long> {
    IdentifierType findByName(String name);
}
