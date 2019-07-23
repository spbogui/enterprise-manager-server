package org.hispci.enterprisemanager.domain.activities;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class Activity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;
    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @NonNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @NonNull
    @Column(nullable = false)
    private String subject;
    @ManyToMany
    @JoinTable(name = "activity_structure",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "structure_id"))
    private Collection<Structure> structures;

    @ManyToMany
    @JoinTable(name = "activity_staff_members",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private Collection<Staff> staffs;

    @ManyToMany
    @JoinTable(name = "activity_members",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Collection<ActivityMember> activityMembers = new ArrayList<>();

}
