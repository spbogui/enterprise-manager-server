package org.hispci.enterprisemanager.domain.employment.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hispci.enterprisemanager.base.BaseEntity;
import org.hispci.enterprisemanager.domain.employment.contracts.Contract;
import org.hispci.enterprisemanager.domain.persons.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Staff extends BaseEntity {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "person"))
    private Long id;
    @OneToMany(mappedBy = "staff")
    private Collection<StaffIdentifier> staffIdentifiers = new ArrayList<>();
    @NonNull
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @OneToMany(mappedBy = "staff")
    private Collection<StaffPost> staffPosts = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private Collection<Contract> contracts = new ArrayList<>();
    //@MapsId
    @OneToOne
//    @JoinColumn(name = "staff_id", referencedColumnName = "person_id", nullable = false)
    @PrimaryKeyJoinColumn
    private Person person;

}
