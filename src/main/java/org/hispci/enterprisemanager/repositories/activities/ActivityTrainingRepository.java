package org.hispci.enterprisemanager.repositories.activities;

import org.hispci.enterprisemanager.domain.activities.ActivityTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ActivityTrainingRepository extends JpaRepository<ActivityTraining, Long> {
    ActivityTraining findByUuid(String uuid);
    List<ActivityTraining> findByRetired(Boolean retired);
}
