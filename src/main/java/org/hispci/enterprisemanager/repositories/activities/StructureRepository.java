package org.hispci.enterprisemanager.repositories.activities;

import org.hispci.enterprisemanager.domain.activities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StructureRepository extends JpaRepository<Structure, Long> {
}
