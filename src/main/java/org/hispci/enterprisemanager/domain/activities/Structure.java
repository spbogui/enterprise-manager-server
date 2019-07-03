package org.hispci.enterprisemanager.domain.activities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Structure implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false, unique = true, length = 65)
    private String name;
    private String initial;
    private String registered;
    @NonNull
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    private String address;
}
