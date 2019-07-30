package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.ActivityType;
import org.hispci.enterprisemanager.repositories.activities.ActivityTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activity-types")
@CrossOrigin("*")
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
    @PostMapping
    public ActivityType save(@RequestBody ActivityType activityType) {
        return activityTypeRepository.save(activityType);
    }

    /**
     * updateActivity()
     * @param activityType
     * @return ActivityType
     */
    @PutMapping
    public ActivityType update(@RequestBody ActivityType activityType) {
        return activityTypeRepository.saveAndFlush(activityType);
    }

    /**
     * remove()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
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
    @GetMapping
    public List<ActivityType> findAll() {
        return activityTypeRepository.findAll();
    }

    /**
     * getOne()
     * @param id
     * @return Activity
     */
    @GetMapping("/{id}")
    public ActivityType getOne(@PathVariable Long id){
        return activityTypeRepository.findById(id).orElse(null);
    }

}
