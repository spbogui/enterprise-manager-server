package org.hispci.enterprisemanager.domain.users;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Privilege implements Serializable {
    @Id
    @NonNull
    private String name;
    private String description;
}
