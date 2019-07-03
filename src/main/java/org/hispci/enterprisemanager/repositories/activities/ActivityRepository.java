package org.hispci.enterprisemanager.repositories.activities;


import org.hispci.enterprisemanager.domain.activities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findByUuid(String uuid);
    List<Activity> findByRetired(Boolean retired);
}
