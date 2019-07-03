package org.hispci.enterprisemanager.domain.employment.leaves;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class LeavePermission extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeavePermissionType leavePermissionType;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "asking_leave_id", nullable = false)
    private LeavePermissionRequest askingLeave;
    @NonNull
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private int daysTakenOff;
}
