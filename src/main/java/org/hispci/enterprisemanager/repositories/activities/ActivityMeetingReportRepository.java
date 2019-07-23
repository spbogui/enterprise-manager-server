package org.hispci.enterprisemanager.repositories.activities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActivityMeetingReportRepository extends JpaRepository<ActivityMeetingReport, Long> {
    ActivityMeetingReport findByUuid(String uuid);
}
