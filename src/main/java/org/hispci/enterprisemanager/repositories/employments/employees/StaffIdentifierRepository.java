package org.hispci.enterprisemanager.repositories.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.domain.employment.employees.StaffIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StaffIdentifierRepository extends JpaRepository<StaffIdentifier, Long> {
    StaffIdentifier findByIdentifier(String identifier);
    List<StaffIdentifier> findByStaff(Staff staff);
}
