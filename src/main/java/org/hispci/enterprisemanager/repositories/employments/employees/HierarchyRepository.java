package org.hispci.enterprisemanager.repositories.employments.employees;


import org.hispci.enterprisemanager.domain.employment.employees.Hierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HierarchyRepository extends JpaRepository<Hierarchy, Long> {
    List<Hierarchy> findByNameContaining(String name);

    List<Hierarchy> findByParentHierarchy_Name(String name);

    Hierarchy findByName(String name);
}
