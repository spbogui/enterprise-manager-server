package org.hispci.enterprisemanager.repositories.activities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActivitySupervisionReportRepository extends JpaRepository<ActivitySupervisionReport, Long> {
}
