package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.contracts.Contract;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.repositories.employments.contracts.ContractRepository;
import org.hispci.enterprisemanager.repositories.employments.employees.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/contracts")
@RestController
public class ContractRestServiceResource {

    private ContractRepository contractRepository;
    private StaffRepository staffRepository;

    public ContractRestServiceResource(ContractRepository contractRepository, StaffRepository staffRepository) {
        this.contractRepository = contractRepository;
        this.staffRepository = staffRepository;
    }

    @PostMapping
    @ResponseBody
    public Contract save(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }

    @PutMapping("/{id}")
    public Contract update(@PathVariable Long id) {

        return contractRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean remove(Long id) {
        Optional<Contract> result = contractRepository.findById(id);
        if (result.isPresent()) {
            contractRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Contract findById(@PathVariable Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @GetMapping("/contract-type/{contractType}")
    public List<Contract> findContractByName(@PathVariable String contractType) {
        return contractRepository.findByContractType_NameAndIsActual(contractType, true);
    }

    @GetMapping("/staff/{id}")
    public List<Contract> findByStaff(@PathVariable Long id) {
        Staff staff = staffRepository.findById(id).orElse(null);
        if (staff != null)
            return contractRepository.findByStaff(staff);
        return null;
    }

    @GetMapping("/staff-actual/{id}")
    public Contract findByStaffAndIsActual(@PathVariable Long id) {
        Staff staff = staffRepository.findById(id).orElse(null);
        if (staff != null)
            return contractRepository.findByStaffAndIsActual(staff, true);
        return null;
    }

    @GetMapping("/end-other-contracts/{staffId}/{id}")
    public void endOtherContract(@PathVariable Long staffId, @PathVariable Long id) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            for (Contract contract : contractRepository.findByStaffAndIdIsNot(staff, id)) {
                if (contract.getIsActual()) {
                    contract.setIsActual(false);
                    contractRepository.save(contract);
                }
            }
        }
    }
}
