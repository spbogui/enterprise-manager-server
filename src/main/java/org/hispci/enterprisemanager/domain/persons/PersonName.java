package org.hispci.enterprisemanager.domain.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class PersonName implements Serializable {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "person"))
    private Long id;
    private Boolean preferred;
    @NonNull
    @JsonIgnore
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "id", nullable = false)
    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;
    private String prefix;
    @NonNull
    @Column(nullable = false)
    private String givenName;
    private String middleName;
    private String familyNamePrefix;
    @NonNull
    @Column(nullable = false)
    private String familyName;
    private String familyName2;
    private String familyNameSuffix;
    private String degree;
}
