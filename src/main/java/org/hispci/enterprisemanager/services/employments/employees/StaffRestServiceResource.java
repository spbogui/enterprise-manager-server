package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.contracts.Contract;
import org.hispci.enterprisemanager.domain.employment.employees.*;
import org.hispci.enterprisemanager.repositories.employments.contracts.ContractRepository;
import org.hispci.enterprisemanager.repositories.employments.employees.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/staffs")
@RestController
public class StaffRestServiceResource {

    private StaffRepository staffRepository;
    private StaffIdentifierRepository staffIdentifierRepository;
    private PostRepository postRepository;
    private JobRepository jobRepository;
    private GradeRepository gradeRepository;
    private ContractRepository contractRepository;
    private StaffPostRepository staffPostRepository;

    public StaffRestServiceResource(StaffRepository staffRepository, StaffIdentifierRepository staffIdentifierRepository,
                                    PostRepository postRepository, JobRepository jobRepository, GradeRepository gradeRepository,
                                    ContractRepository contractRepository, StaffPostRepository staffPostRepository) {
        this.staffRepository = staffRepository;
        this.staffIdentifierRepository = staffIdentifierRepository;
        this.postRepository = postRepository;
        this.jobRepository = jobRepository;
        this.gradeRepository = gradeRepository;
        this.contractRepository = contractRepository;
        this.staffPostRepository = staffPostRepository;
    }

    @PostMapping
    public Staff saveStaff(@RequestBody Staff staff) {
        staffRepository.save(staff);

        staff.getStaffIdentifiers().forEach(staffIdentifier -> {
            staffIdentifier.setStaff(staff);
            staffIdentifierRepository.save(staffIdentifier);
        });

        staff.getStaffPosts().forEach(staffPost -> {
            staffPost.setStaff(staff);
            staffPostRepository.save(staffPost);
        });

        staff.getContracts().forEach(contract -> {
            contract.setStaff(staff);
            contractRepository.save(contract);
        });

        return staff;
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStaff(@PathVariable Long id) {
        Optional<Staff> result = staffRepository.findById(id);
        if (result.isPresent()) {
            staffRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Staff findById(@PathVariable Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<Staff> findStaffByName(@PathVariable String name) {
        return null; //staffRepository.findByNameContaining(name);
    }

    @GetMapping("/identifier/{identifier}")
    public Staff findStaffByIdentifier(@PathVariable String identifier) {
        StaffIdentifier staffIdentifier = staffIdentifierRepository.findByIdentifier(identifier);
        if (staffIdentifier != null) {
            return staffRepository.findByStaffIdentifiersContains(staffIdentifier);
        }
        return null;
    }

    @GetMapping("/post/{post}")
    public List<Staff> findStaffByPost(@PathVariable String post) {
        Post p = postRepository.findByName(post);
        if (p != null) {
            return staffRepository.findByStaffPostsContains(p);
        }
        return null;
    }

    @GetMapping("/job/{job}")
    public List<Staff> findStaffByJob(@PathVariable String job) {
        Job j = jobRepository.findByName(job);
        if (j != null) {
            return staffRepository.findByJob(j);
        }
        return null;
    }

    @GetMapping("/grade/{:grade}")
    public List<Staff> findStaffByGrade(@PathVariable String grade) {
        Grade g = gradeRepository.findByName(grade);
        if (g != null) {
            return staffRepository.findByGrade(g);
        }
        return null;
    }

    @GetMapping("/contract-type/{contractType}")
    public List<Staff> findStaffByContract(@PathVariable String contractType) {
        List<Contract> contracts = contractRepository.findByContractType_NameAndIsActual(contractType, true);
        if (!contracts.isEmpty()) {
            return staffRepository.findByContractsIn(contracts);
        }
        return null;
    }
}
