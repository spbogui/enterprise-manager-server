package org.hispci.enterprisemanager.repositories.locations;

import org.hispci.enterprisemanager.domain.locations.LocationAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationAttributeRepository extends JpaRepository<LocationAttribute, Long> {
}
