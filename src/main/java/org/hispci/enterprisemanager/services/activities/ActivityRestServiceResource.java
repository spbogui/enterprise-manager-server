package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.Activity;
import org.hispci.enterprisemanager.domain.activities.ActivityMember;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.repositories.activities.ActivityMemberRepository;
import org.hispci.enterprisemanager.repositories.activities.ActivityRepository;
import org.hispci.enterprisemanager.repositories.employments.employees.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActivityRestServiceResource {
    private final ActivityRepository activityRepository;
    private final StaffRepository staffRepository;
    private final ActivityMemberRepository activityMemberRepository;

    public ActivityRestServiceResource(ActivityRepository activityRepository, StaffRepository staffRepository, ActivityMemberRepository activityMemberRepository) {
        this.activityRepository = activityRepository;
        this.staffRepository = staffRepository;
        this.activityMemberRepository = activityMemberRepository;
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
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    /**
     * update()
     * @param activity
     * @return Activity
     */
    @PutMapping("/activities")
    public Activity update(Activity activity) {
        return activityRepository.saveAndFlush(activity);
    }

    /**
     * remove()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/activities/{id}")
    public Boolean remove(@PathVariable Long id) {
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
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    /**
     * getActivity()
     * @param id
     * @return Activity
     */
    @GetMapping("/activities/{id}")
    public Activity getOne(@PathVariable Long id){
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

    /**
     * addStaffMember()
     * @param activityId
     * @param staffId
     * @return Activity
     */
    @GetMapping("/activities/add-staff/activityId/staffId")
    public Activity addStaffMember(@RequestParam Long activityId, @RequestParam Long staffId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            Activity activity = activityRepository.findById(activityId).orElse(null);
            if (activity != null) {
                activity.getStaffs().add(staff);
                return  activityRepository.save(activity);
            }
        }
        return null;
    }

    /**
     * addExternalMember()
     * @param activityId
     * @param activityMemberId
     * @return Activity
     */
    @GetMapping("/activities/add-member/activityId/activityMemberId")
    public Activity addExternalMember(@RequestParam Long activityId, @RequestParam Long activityMemberId) {
        ActivityMember activityMember = activityMemberRepository.findById(activityMemberId).orElse(null);
        if (activityMember != null) {
            Activity activity = activityRepository.findById(activityId).orElse(null);
            if (activity != null) {
                activity.getActivityMembers().add(activityMember);
                return  activityRepository.save(activity);
            }
        }
        return null;
    }


}
