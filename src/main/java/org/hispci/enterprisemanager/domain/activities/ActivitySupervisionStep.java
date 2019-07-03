package org.hispci.enterprisemanager.domain.activities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.domain.locations.Location;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ActivitySupervisionStep {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stepId;
    @ManyToOne
    private ActivitySupervision activitySupervision;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    private String description;
    private Location location;

    @ManyToMany
    @JoinTable(name = "supervision_step_staff_members",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private Collection<Staff> staffs;

    @ManyToMany
    @JoinTable(name = "supervision_step_members",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Collection<ActivityMember> activityMembers = new ArrayList<>();

}
