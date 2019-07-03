package org.hispci.enterprisemanager.domain.persons;

import lombok.*;
import org.hispci.enterprisemanager.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

//@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
//@Accessors(fluent = true)
public class Person extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false, length = 30)
    private String gender;
    @NonNull
    private Date birthDate;
    @Column(nullable = false)
    private Boolean birthDateEstimated = false;
    private String birthPlace;
//    private Boolean dead = false;
//    private Date deathDate;
//    private String causeOfDeath;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonName personName;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonAddress personAddress;
    private String photoName;
}
