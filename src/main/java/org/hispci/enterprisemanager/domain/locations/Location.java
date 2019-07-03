package org.hispci.enterprisemanager.domain.locations;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Location implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    @NonNull
    @Column(nullable = false, unique = true)
    private String code;
    @NonNull
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @ManyToOne
    private LocationLevel locationLevel;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();

}
