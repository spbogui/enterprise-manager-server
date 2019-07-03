package org.hispci.enterprisemanager.domain.employment.employees;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Hierarchy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false, unique = true, length = 65)
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;
    @ManyToOne
    @JoinColumn(name = "parent_hierarchy")
    private Hierarchy parentHierarchy;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();
}
