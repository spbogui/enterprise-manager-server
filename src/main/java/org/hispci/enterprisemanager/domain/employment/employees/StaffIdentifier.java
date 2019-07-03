package org.hispci.enterprisemanager.domain.employment.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor
public class StaffIdentifier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "identifier_type_id", nullable = false)
    private IdentifierType identifierType;
    @NonNull
    @Column(nullable = false, length = 64, unique = true)
    private String identifier;
    private Boolean preferred = true;
}
