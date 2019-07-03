package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.leaves.LeavePermissionType;
import org.hispci.enterprisemanager.repositories.employments.leaves.LeavePermissionTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/leave-permission-types")
@RestController
public class LeavePermissionTypeRestServiceResource {

    private LeavePermissionTypeRepository leavePermissionTypeRepository;

    public LeavePermissionTypeRestServiceResource(LeavePermissionTypeRepository leavePermissionTypeRepository) {
        this.leavePermissionTypeRepository = leavePermissionTypeRepository;
    }

    @PostMapping
    public LeavePermissionType saveLeavePermissionType(@RequestBody LeavePermissionType contractType) {
        return leavePermissionTypeRepository.save(contractType);
    }

    @PutMapping("/{id}")
    public LeavePermissionType updateLeavePermissionType(@PathVariable Long id) {
        return leavePermissionTypeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteLeavePermissionType(@PathVariable Long id) {
        Optional<LeavePermissionType> result = leavePermissionTypeRepository.findById(id);
        if (result.isPresent()) {
            leavePermissionTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<LeavePermissionType> findAllLeavePermissionType() {
        return leavePermissionTypeRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public LeavePermissionType findById(@PathVariable Long id) {
        return leavePermissionTypeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<LeavePermissionType> findLeavePermissionTypeByName(@PathVariable String name) {
        return leavePermissionTypeRepository.findByNameContaining(name);
    }
}
