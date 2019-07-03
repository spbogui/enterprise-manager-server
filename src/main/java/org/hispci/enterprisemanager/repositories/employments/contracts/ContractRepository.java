package org.hispci.enterprisemanager.repositories.employments.contracts;

import org.hispci.enterprisemanager.domain.employment.contracts.Contract;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByContractType_NameAndEndDateIsNullOrEndDateAfter(String contractType_Name, Date endDate);
    List<Contract> findByContractType_NameAndIsActual(String contractType_Name, Boolean isActual);
    List<Contract> findByStaff(Staff staff);
    Contract findByStaffAndIsActual(Staff staff, Boolean isActual);
    List<Contract> findByStaffAndIdIsNot(Staff staff, Long id);
}
