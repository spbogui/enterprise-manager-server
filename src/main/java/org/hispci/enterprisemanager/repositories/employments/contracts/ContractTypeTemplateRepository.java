package org.hispci.enterprisemanager.repositories.employments.contracts;

import org.hispci.enterprisemanager.domain.employment.contracts.ContractTypeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContractTypeTemplateRepository extends JpaRepository<ContractTypeTemplate, Long> {
}
