package org.hispci.enterprisemanager.domain.employment.employees;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(length = 60, nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "hierarchy_id")
    private Hierarchy hierarchy;
    private String description;
    private Integer numberAvailable = 1;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();
}
