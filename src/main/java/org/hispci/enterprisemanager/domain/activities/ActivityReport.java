package org.hispci.enterprisemanager.domain.activities;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class ActivityReport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NonNull
//    @ManyToOne
//    @JoinColumn(name = "activity_id", nullable = false)
//    private Activity activity;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @NonNull
    @Column(nullable = false)
    private Date reportDate;
    @NonNull
    @Column(nullable = false)
    private String status;
    private byte content;
}
