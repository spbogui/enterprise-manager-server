package org.hispci.enterprisemanager.repositories.activities;


import org.hispci.enterprisemanager.domain.activities.ActivityMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActivityMemberRepository extends JpaRepository<ActivityMember, Long> {
}
