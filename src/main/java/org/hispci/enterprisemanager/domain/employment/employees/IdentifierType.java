package org.hispci.enterprisemanager.domain.employment.employees;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class IdentifierType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(length = 65, nullable = false, unique = true)
    private String name;
    private String description;
    private String format;
    @Column(length = 36, nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();
}
