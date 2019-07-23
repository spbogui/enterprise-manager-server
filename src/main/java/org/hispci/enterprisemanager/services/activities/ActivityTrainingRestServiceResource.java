package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.ActivityTraining;
import org.hispci.enterprisemanager.repositories.activities.ActivityTrainingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class ActivityTrainingRestServiceResource {
    private final ActivityTrainingRepository activityTrainingRepository;

    public ActivityTrainingRestServiceResource(ActivityTrainingRepository activityTrainingRepository) {
        this.activityTrainingRepository = activityTrainingRepository;
    }

    /******************************************************
     * ACTIVITY RESOURCES
     ******************************************************/

    /**
     * saveActivity()
     * @param activity
     * @return ActivityTraining
     */
    @PostMapping("/training")
    public ActivityTraining save(ActivityTraining activity) {
        return activityTrainingRepository.save(activity);
    }

    /**
     * updateActivity()
     * @param activity
     * @return ActivityTraining
     */
    @PutMapping("/training")
    public ActivityTraining update(ActivityTraining activity) {
        return activityTrainingRepository.saveAndFlush(activity);
    }

    /**
     * deleteActivity()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/training/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<ActivityTraining> result = activityTrainingRepository.findById(id);

        if (result.isPresent()) {
            activityTrainingRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAll()
     * @return List<ActivityTraining>
     */
    @GetMapping("/training")
    public List<ActivityTraining> findAll() {
        return activityTrainingRepository.findAll();
    }

    /**
     * getActivity()
     * @param id
     * @return ActivityTraining
     */
    @GetMapping("/training/{id}")
    public ActivityTraining getOne(@PathVariable Long id){
        return activityTrainingRepository.findById(id).orElse(null);
    }

    /**
     * findByUuid()
     * @param uuid
     * @return ActivityTraining
     */
    @GetMapping("/training/{uuid}")
    public ActivityTraining findByUuid(@PathVariable String uuid) {
        return activityTrainingRepository.findByUuid(uuid);
    }

}
