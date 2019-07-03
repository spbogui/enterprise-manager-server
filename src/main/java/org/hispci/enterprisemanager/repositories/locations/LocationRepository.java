package org.hispci.enterprisemanager.repositories.locations;

import org.hispci.enterprisemanager.domain.locations.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location, Long> {
}
