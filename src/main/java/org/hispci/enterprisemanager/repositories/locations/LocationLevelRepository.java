package org.hispci.enterprisemanager.repositories.locations;

import org.hispci.enterprisemanager.domain.locations.LocationLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationLevelRepository extends JpaRepository<LocationLevel, Long> {
}
