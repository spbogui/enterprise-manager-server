package org.hispci.enterprisemanager.repositories.employments.departures;

import org.hispci.enterprisemanager.domain.employment.departures.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartureRepository extends JpaRepository<Departure, Long> {
}
