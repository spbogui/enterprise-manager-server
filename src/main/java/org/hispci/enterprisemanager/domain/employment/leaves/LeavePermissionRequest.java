package org.hispci.enterprisemanager.domain.employment.leaves;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class LeavePermissionRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeavePermissionType leavePermissionType;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @NonNull
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date askingDate = new Date();
    @Temporal(value = TemporalType.DATE)
    private Date startDate;
    @NonNull
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;
    private String memo;
    @OneToOne(mappedBy = "leavePermissionRequest", cascade = CascadeType.ALL)
    private LeavePermissionRequestAnswer leavePermissionRequestAnswer;
}
