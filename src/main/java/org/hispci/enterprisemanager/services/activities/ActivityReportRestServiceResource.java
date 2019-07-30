package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.ActivityReport;
import org.hispci.enterprisemanager.repositories.activities.ActivityReportRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activity-reports")
@CrossOrigin("*")
public class ActivityReportRestServiceResource {
    private final ActivityReportRepository activityReportRepository;

    public ActivityReportRestServiceResource(ActivityReportRepository activityReportRepository) {
        this.activityReportRepository = activityReportRepository;
    }

    /******************************************************
     * ACTIVITY RESOURCES
     ******************************************************/

    /**
     * saveActivity()
     * @param activityReport
     * @return Activity
     */
    @PostMapping
    public ActivityReport save(@RequestBody ActivityReport activityReport) {
        return activityReportRepository.save(activityReport);
    }

    /**
     * update()
     * @param activityReport
     * @return Activity
     */
    @PutMapping
    public ActivityReport update(@RequestBody ActivityReport activityReport) {
        return activityReportRepository.saveAndFlush(activityReport);
    }

    /**
     * remove()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<ActivityReport> result = activityReportRepository.findById(id);

        if (result.isPresent()) {
            activityReportRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAllActivities()
     * @return List<Activity>
     */
    @GetMapping
    public List<ActivityReport> findAll() {
        return activityReportRepository.findAll();
    }

    /**
     * getActivity()
     * @param id
     * @return Activity
     */
    @GetMapping("/{id}")
    public ActivityReport getOne(@PathVariable Long id){
        return activityReportRepository.findById(id).orElse(null);
    }

    /**
     * findByUuid()
     * @param uuid
     * @return Activity
     */
    @GetMapping("/uuid/{uuid}")
    public ActivityReport findByUuid(@PathVariable String uuid) {
        return activityReportRepository.findByUuid(uuid);
    }

}
