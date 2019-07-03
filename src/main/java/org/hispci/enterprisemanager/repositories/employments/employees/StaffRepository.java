package org.hispci.enterprisemanager.repositories.employments.employees;

import org.hispci.enterprisemanager.domain.employment.contracts.Contract;
import org.hispci.enterprisemanager.domain.employment.employees.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByStaffIdentifiersContains(StaffIdentifier staffIdentifier);

    List<Staff> findByStaffPostsContains(Post p);

    List<Staff> findByJob(Job j);

    List<Staff> findByGrade(Grade g);

    List<Staff> findByContractsIn(List<Contract> contracts);
}
