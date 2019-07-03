package org.hispci.enterprisemanager.repositories.employments.leaves;

import org.hispci.enterprisemanager.domain.employment.leaves.LeavePermissionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LeavePermissionRequestRepository extends JpaRepository<LeavePermissionRequest, Long> {
}
