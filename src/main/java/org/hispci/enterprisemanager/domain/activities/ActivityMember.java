package org.hispci.enterprisemanager.domain.activities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hispci.enterprisemanager.domain.persons.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class ActivityMember implements Serializable {
    @Id
    private Long activityMemberId;
    @NonNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @NonNull
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    @OneToOne
    private Person person;
    private Structure structure;
}
