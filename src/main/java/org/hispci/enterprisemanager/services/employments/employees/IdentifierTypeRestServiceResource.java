package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.IdentifierType;
import org.hispci.enterprisemanager.repositories.employments.employees.IdentifierTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/identifier-types")
@RestController
public class IdentifierTypeRestServiceResource {

    private IdentifierTypeRepository identifierTypeRepository;

    public IdentifierTypeRestServiceResource(IdentifierTypeRepository identifierTypeRepository) {
        this.identifierTypeRepository = identifierTypeRepository;
    }

    @PostMapping
    public IdentifierType saveIdentifierType(@RequestBody IdentifierType identifierType) {
        return identifierTypeRepository.save(identifierType);
    }

    @PutMapping("/{id}")
    public IdentifierType updateIdentifierType(@PathVariable Long id) {
        return identifierTypeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteIdentifierType(@PathVariable Long id) {
        Optional<IdentifierType> result = identifierTypeRepository.findById(id);
        if (result.isPresent()) {
            identifierTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<IdentifierType> findAllIdentifierType() {
        return identifierTypeRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public IdentifierType findById(@PathVariable Long id) {
        return identifierTypeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public IdentifierType findIdentifierTypeByName(@PathVariable String name) {
        return identifierTypeRepository.findByName(name);
    }
}
