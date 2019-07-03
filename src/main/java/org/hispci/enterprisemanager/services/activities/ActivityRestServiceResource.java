package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.Activity;
import org.hispci.enterprisemanager.repositories.activities.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActivityRestServiceResource {
    private final ActivityRepository activityRepository;

    public ActivityRestServiceResource(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    /******************************************************
     * ACTIVITY RESOURCES
     ******************************************************/

    /**
     * saveActivity()
     * @param activity
     * @return Activity
     */
    @PostMapping("/activities")
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    /**
     * updateActivity()
     * @param activity
     * @return Activity
     */
    @PutMapping("/activities")
    public Activity updateActivity(Activity activity) {
        return activityRepository.saveAndFlush(activity);
    }

    /**
     * deleteActivity()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/activities/{id}")
    public Boolean deleteActivity(@PathVariable Long id) {
        Optional<Activity> result = activityRepository.findById(id);

        if (result.isPresent()) {
            activityRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAllActivities()
     * @return List<Activity>
     */
    @GetMapping("/activities")
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    /**
     * getActivity()
     * @param id
     * @return Activity
     */
    @GetMapping("/activities/{id}")
    public Activity getActivity(@PathVariable Long id){
        return activityRepository.findById(id).orElse(null);
    }

    /**
     * findByUuid()
     * @param uuid
     * @return Activity
     */
    @GetMapping("/activities/{uuid}")
    public Activity findByUuid(@PathVariable String uuid) {
        return activityRepository.findByUuid(uuid);
    }

}
