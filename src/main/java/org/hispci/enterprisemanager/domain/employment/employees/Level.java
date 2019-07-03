package org.hispci.enterprisemanager.domain.employment.employees;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Level implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(length = 65, nullable = false, unique = true)
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "parent_level")
    private Level parentLevel;
    @Column(length = 36, nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();
}
