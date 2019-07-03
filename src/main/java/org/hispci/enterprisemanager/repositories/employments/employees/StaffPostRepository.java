package org.hispci.enterprisemanager.repositories.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.domain.employment.employees.StaffPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StaffPostRepository extends JpaRepository<StaffPost, Long> {
    List<StaffPost> findByStaff(Staff staff);
}
