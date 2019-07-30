package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.ActivityType;
import org.hispci.enterprisemanager.repositories.activities.ActivityTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActivityTypeRestServiceResource {
    private final ActivityTypeRepository activityTypeRepository;

    public ActivityTypeRestServiceResource(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    /******************************************************
     * ACTIVITY RESOURCES
     ******************************************************/

    /**
     * saveActivity()
     * @param activityType
     * @return ActivityType
     */
    @PostMapping("/activity-types")
    public ActivityType save(ActivityType activityType) {
        return activityTypeRepository.save(activityType);
    }

    /**
     * updateActivity()
     * @param activityType
     * @return ActivityType
     */
    @PutMapping("/activity-types")
    public ActivityType update(ActivityType activityType) {
        return activityTypeRepository.saveAndFlush(activityType);
    }

    /**
     * remove()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/activity-types/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<ActivityType> result = activityTypeRepository.findById(id);

        if (result.isPresent()) {
            activityTypeRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAll()
     * @return List<Activity>
     */
    @GetMapping("/activity-types")
    public List<ActivityType> findAll() {
        return activityTypeRepository.findAll();
    }

    /**
     * getOne()
     * @param id
     * @return Activity
     */
    @GetMapping("/activity-types/{id}")
    public ActivityType getOne(@PathVariable Long id){
        return activityTypeRepository.findById(id).orElse(null);
    }

}
