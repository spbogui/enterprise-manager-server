package org.hispci.enterprisemanager.domain.locations;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor @ToString
public class LocationLevel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationLevelId;
    @NonNull
    @Column(nullable = false, unique = true)
    private String name;
    private int levelNumber;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();
}
