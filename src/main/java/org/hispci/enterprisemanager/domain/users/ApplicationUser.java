package org.hispci.enterprisemanager.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hispci.enterprisemanager.domain.persons.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class ApplicationUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(nullable = false, unique = true, length = 100)
    private String systemId;
    @Column(nullable = false, unique = true, length = 65)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    private String email;
    private Boolean actived = true;
    @Column(nullable = false)
    private Date dateCreated = new Date();
    private Date dateChanged;
    @Column(nullable = false)
    private Boolean retired = false;
    private Date dateRetired;
    private String retireReason;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles = new LinkedHashSet<Role>();
}
