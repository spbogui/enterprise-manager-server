package org.hispci.enterprisemanager.domain.employment.departures;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Departure extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "departure_type_id", nullable = false)
    private DepartureType departureType;
    @NonNull
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date departureDate;
    @Column(nullable = false)
    private String departureReason;
    private String memo;
}
