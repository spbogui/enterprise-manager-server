package org.hispci.enterprisemanager.domain.activities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data @RequiredArgsConstructor @NoArgsConstructor @AllArgsConstructor
public class ActivityType  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "template_id")
    private ActivityTypeTemplate activityTypeTemplate;
    @NonNull
    @Column(length = 65, nullable = false, unique = true)
    private String name;
    private String description;
    @Column(length = 36, nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();
}
