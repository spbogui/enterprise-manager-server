package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.Activity;

import java.util.List;

public interface ActivityRestService {
    Activity save(Activity activity);
    Activity update(Activity activity);
    Boolean remove(Long activityId);
    Activity findById(Long id);
    List<Activity> findAllByRetired(Boolean retired);
    List<Activity> findAll();
    Activity findByUuid(String uuid);
    Activity retire(Long id);
    Activity unRetire(Long id);
}
