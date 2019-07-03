package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.contracts.ContractType;
import org.hispci.enterprisemanager.repositories.employments.contracts.ContractTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/contract-types")
@RestController
public class ContractTypeRestServiceResource {

    private ContractTypeRepository contractTypeRepository;

    public ContractTypeRestServiceResource(ContractTypeRepository contractTypeRepository) {
        this.contractTypeRepository = contractTypeRepository;
    }

    @PostMapping
    public ContractType saveContractType(@RequestBody ContractType contractType) {
        return contractTypeRepository.save(contractType);
    }

    @PutMapping("/{id}")
    public ContractType updateContractType(@PathVariable Long id) {
        return contractTypeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteContractType(@PathVariable Long id) {
        Optional<ContractType> result = contractTypeRepository.findById(id);
        if (result.isPresent()) {
            contractTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<ContractType> findAllContractType() {
        return contractTypeRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public ContractType findById(@PathVariable Long id) {
        return contractTypeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<ContractType> findContractTypeByName(@PathVariable String name) {
        return contractTypeRepository.findByNameContaining(name);
    }
}
