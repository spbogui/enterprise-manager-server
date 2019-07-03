package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.departures.DepartureType;
import org.hispci.enterprisemanager.repositories.employments.departures.DepartureTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/departure-types")
@RestController
public class DepartureTypeRestServiceResource {

    private DepartureTypeRepository departureTypeRepository;

    public DepartureTypeRestServiceResource(DepartureTypeRepository departureTypeRepository) {
        this.departureTypeRepository = departureTypeRepository;
    }

    @PostMapping
    public DepartureType saveDepartureType(@RequestBody DepartureType job) {
        return departureTypeRepository.save(job);
    }

    @PutMapping("/{id}")
    public DepartureType updateDepartureType(@PathVariable Long id) {
        return departureTypeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteDepartureType(@PathVariable Long id) {
        Optional<DepartureType> result = departureTypeRepository.findById(id);
        if (result.isPresent()) {
            departureTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<DepartureType> findAllDepartureType() {
        return departureTypeRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public DepartureType findById(@PathVariable Long id) {
        return departureTypeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public DepartureType findDepartureTypeByName(@PathVariable String name) {
        return departureTypeRepository.findByName(name);
    }
}
