package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.Activity;

import java.util.List;

public interface ActivityReportRestService {
    Activity save(Activity activity);
    Activity update(Activity activity);
    Activity remove(Long activityId);
    Activity findById(Long id);
    List<Activity> findByRetired(Boolean retired);
    List<Activity> findAll();
    Activity findByUuid(String uuid);
    Activity retire();
    Activity unretire();
}
