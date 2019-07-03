package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.Activity;

import java.util.List;

public interface ActivityTypeRestService {
    Activity save(Activity activity);
    Activity update(Activity activity);
    Activity remove(Long activityId);
    Activity findById(Long id);
    List<Activity> findAll();
}
