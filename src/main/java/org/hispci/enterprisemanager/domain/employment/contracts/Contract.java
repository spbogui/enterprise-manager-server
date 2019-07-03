package org.hispci.enterprisemanager.domain.employment.contracts;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Contract extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, name = "staff_id")
    private Staff staff;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "contract_type_id")
    private ContractType contractType;
    @NonNull
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date signedDate;
    @NonNull
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    @Temporal(value = TemporalType.DATE)
    private Date endDate;
    private Boolean isActual = true;
    @Column(length = 36, nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();
}
