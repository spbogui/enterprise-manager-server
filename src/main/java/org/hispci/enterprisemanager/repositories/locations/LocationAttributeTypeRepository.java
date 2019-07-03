package org.hispci.enterprisemanager.repositories.locations;

import org.hispci.enterprisemanager.domain.locations.LocationAttributeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationAttributeTypeRepository extends JpaRepository<LocationAttributeType, Long> {
}
