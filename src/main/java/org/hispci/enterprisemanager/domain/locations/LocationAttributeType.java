package org.hispci.enterprisemanager.domain.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LocationAttributeType implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationAttributeTypeId;
    @NonNull
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    private String dataType;
    private String maxValue;
    private String minValue;
}
