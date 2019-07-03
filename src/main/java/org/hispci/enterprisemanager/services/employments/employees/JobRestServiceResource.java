package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Job;
import org.hispci.enterprisemanager.repositories.employments.employees.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/jobs")
@RestController
public class JobRestServiceResource {

    private JobRepository jobRepository;

    public JobRestServiceResource(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @PostMapping
    public Job saveJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteJob(@PathVariable Long id) {
        Optional<Job> result = jobRepository.findById(id);
        if (result.isPresent()) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Job> findAllJob() {
        return jobRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Job findById(@PathVariable Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<Job> findJobByName(@PathVariable String name) {
        return jobRepository.findByNameContaining(name);
    }
}
