package org.hispci.enterprisemanager.domain.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class PersonAddress implements Serializable {
    @Id
    private Long id;
    @NonNull
    @JsonIgnore
    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Person person;
    private Boolean preferred;
    @NonNull
    private String address1;
    private String address2;
    private String address3;
    @NonNull
    private String telephone1;
    private String telephone2;
    private String telephone3;
    private String cityVillage;
    private String stateProvince;
    private String postalCode;
    private String country;
    private Double latitude;
    private Double longitude;
    private Date startDate;
    private Date endDate;
}
