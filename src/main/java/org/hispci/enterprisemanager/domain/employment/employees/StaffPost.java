package org.hispci.enterprisemanager.domain.employment.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hispci.enterprisemanager.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class StaffPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    @Column(nullable = false)
    private boolean isActual = true;
}
