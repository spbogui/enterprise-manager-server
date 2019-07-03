package org.hispci.enterprisemanager.domain.locations;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class LocationAttribute implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationAttributeId;
    @NonNull
    private String value;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Location location;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LocationAttributeType locationAttributeType;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();
}
