package org.hispci.enterprisemanager.repositories.employments.employees;


import org.hispci.enterprisemanager.domain.employment.employees.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByNameContaining(String name);

    Grade findByName(String grade);
}
