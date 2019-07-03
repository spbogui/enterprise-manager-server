package org.hispci.enterprisemanager.domain.employment.leaves;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LeavePermissionRequestAnswer extends BaseEntity {
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private LeavePermissionRequest leavePermissionRequest;
    @Column(nullable = false)
    private Date answeringDate = new Date();
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    @NonNull
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date endDate;
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date effectiveReturnDate;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String answerReason;
}
