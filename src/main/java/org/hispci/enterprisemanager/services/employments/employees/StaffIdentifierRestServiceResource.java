package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.domain.employment.employees.StaffIdentifier;
import org.hispci.enterprisemanager.repositories.employments.employees.StaffIdentifierRepository;
import org.hispci.enterprisemanager.repositories.employments.employees.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/staff-identifiers")
@RestController
public class StaffIdentifierRestServiceResource {

    private StaffRepository staffRepository;
    private StaffIdentifierRepository staffIdentifierRepository;

    public StaffIdentifierRestServiceResource(StaffRepository staffRepository, StaffIdentifierRepository staffIdentifierRepository) {
        this.staffRepository = staffRepository;
        this.staffIdentifierRepository = staffIdentifierRepository;
    }

    @PostMapping
    public StaffIdentifier create(@RequestBody StaffIdentifier staffIdentifier) {
        System.out.println(staffIdentifier);
        return staffIdentifierRepository.save(staffIdentifier);
    }

    @PutMapping("/{id}")
    public StaffIdentifier updateStaffIdentifier(@PathVariable Long id) {
        return staffIdentifierRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStaffIdentifier(@PathVariable Long id) {
        Optional<StaffIdentifier> result = staffIdentifierRepository.findById(id);
        if (result.isPresent()) {
            staffIdentifierRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<StaffIdentifier> findAllStaffIdentifiers() {
        return staffIdentifierRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public StaffIdentifier findById(@PathVariable Long id) {
        return staffIdentifierRepository.findById(id).orElse(null);
    }

    @GetMapping("/identifier/{identifier}")
    public StaffIdentifier findStaffByIdentifier(@PathVariable String identifier) {
        return staffIdentifierRepository.findByIdentifier(identifier);
    }

    @GetMapping("/staff/{staffId}")
    public List<StaffIdentifier> findByStaff(Long staffId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            return staffIdentifierRepository.findByStaff(staff);
        }
        return null;
    }

}
