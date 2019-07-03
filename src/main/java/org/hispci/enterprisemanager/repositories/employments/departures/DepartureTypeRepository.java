package org.hispci.enterprisemanager.repositories.employments.departures;


import org.hispci.enterprisemanager.domain.employment.departures.DepartureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DepartureTypeRepository extends JpaRepository<DepartureType, Long> {
    List<DepartureType> findByNameContaining(String name);
    DepartureType findByName(String name);
}
