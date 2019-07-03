package org.hispci.enterprisemanager.repositories.employments.contracts;

import org.hispci.enterprisemanager.domain.employment.contracts.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ContractTypeRepository extends JpaRepository<ContractType, Long> {
    List<ContractType> findByNameContaining(String name);
    ContractType findByName(String name);
}
