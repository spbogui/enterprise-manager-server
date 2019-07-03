package org.hispci.enterprisemanager.domain.users;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Role implements Serializable {
    @Id
    @NonNull
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_privileges",
            joinColumns = @JoinColumn(name = "role"),
            inverseJoinColumns = @JoinColumn(name = "privilege"))
    private Set<Privilege> privileges = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_roles",
            joinColumns = @JoinColumn(name = "parent_role"),
            inverseJoinColumns = @JoinColumn(name = "child_role"))
    private Set<Role> roles = new HashSet<>();
}
