package org.hispci.enterprisemanager.repositories.employments.leaves;

import org.hispci.enterprisemanager.domain.employment.leaves.LeavePermissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LeavePermissionTypeRepository extends JpaRepository<LeavePermissionType, Long> {
    List<LeavePermissionType> findByNameContaining(String name);
}
