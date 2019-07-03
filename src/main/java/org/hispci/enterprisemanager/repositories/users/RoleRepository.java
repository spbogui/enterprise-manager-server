package org.hispci.enterprisemanager.repositories.users;

import org.hispci.enterprisemanager.domain.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, String> {
}
