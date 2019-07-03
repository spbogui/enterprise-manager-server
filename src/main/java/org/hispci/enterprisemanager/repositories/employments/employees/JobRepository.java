package org.hispci.enterprisemanager.repositories.employments.employees;


import org.hispci.enterprisemanager.domain.employment.employees.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByNameContaining(String name);
    Job findByName(String name);
}
