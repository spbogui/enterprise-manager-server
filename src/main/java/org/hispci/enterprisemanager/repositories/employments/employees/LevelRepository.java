package org.hispci.enterprisemanager.repositories.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findByNameContaining(String name);
    Level findByName(String name);
    List<Level> findByParentLevel_Name(String name);
}
