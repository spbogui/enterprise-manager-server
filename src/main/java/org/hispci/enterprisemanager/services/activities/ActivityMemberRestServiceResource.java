package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.ActivityMember;
import org.hispci.enterprisemanager.repositories.activities.ActivityMemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin("*")
public class ActivityMemberRestServiceResource {
    private final ActivityMemberRepository activityRepository;

    public ActivityMemberRestServiceResource(ActivityMemberRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    /******************************************************
     * ACTIVITY RESOURCES
     ******************************************************/

    /**
     * saveActivity()
     * @param activityMember
     * @return ActivityMember
     */
    @PostMapping("/members")
    public ActivityMember save(@RequestBody ActivityMember activityMember) {
        return activityRepository.save(activityMember);
    }

    /**
     * updateActivity()
     * @param activityMember
     * @return ActivityMember
     */
    @PutMapping("/members")
    public ActivityMember update(@RequestBody ActivityMember activityMember) {
        return activityRepository.saveAndFlush(activityMember);
    }

    /**
     * remove()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/members/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<ActivityMember> result = activityRepository.findById(id);

        if (result.isPresent()) {
            activityRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAll()
     * @return List<Activity>
     */
    @GetMapping("/members")
    public List<ActivityMember> findAll() {
        return activityRepository.findAll();
    }

    /**
     * getOne()
     * @param id
     * @return Activity
     */
    @GetMapping("/members/{id}")
    public ActivityMember getOne(@PathVariable Long id){
        return activityRepository.findById(id).orElse(null);
    }

}
