package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.domain.employment.employees.StaffPost;
import org.hispci.enterprisemanager.repositories.employments.employees.StaffPostRepository;
import org.hispci.enterprisemanager.repositories.employments.employees.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/staff-posts")
@RestController
public class StaffPostRestServiceResource {

    private StaffRepository staffRepository;
    private StaffPostRepository staffPostRepository;

    public StaffPostRestServiceResource(StaffRepository staffRepository, StaffPostRepository staffPostRepository) {
        this.staffRepository = staffRepository;
        this.staffPostRepository = staffPostRepository;
    }

    @PostMapping
    public StaffPost create(@RequestBody StaffPost staffIdentifier) {
        return staffPostRepository.save(staffIdentifier);
    }

    @PutMapping("/{id}")
    public StaffPost update(@PathVariable Long id) {
        return staffPostRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<StaffPost> result = staffPostRepository.findById(id);
        if (result.isPresent()) {
            staffPostRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<StaffPost> findAll() {
        return staffPostRepository.findAll();
    }

    @GetMapping("/staff/{id}")
    public List<StaffPost> findBySTaff(@PathVariable Long id) {
        Staff staff = staffRepository.findById(id).orElse(null);
        if (staff != null) {
            return staffPostRepository.findByStaff(staff);
        }
        return null;
    }

    @GetMapping("/{id:[\\d]+}")
    public StaffPost findById(@PathVariable Long id) {
        return staffPostRepository.findById(id).orElse(null);
    }


}
