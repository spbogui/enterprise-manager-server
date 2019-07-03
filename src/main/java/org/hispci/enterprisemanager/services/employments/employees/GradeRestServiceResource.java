package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Grade;
import org.hispci.enterprisemanager.repositories.employments.employees.GradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/grades")
@RestController
public class GradeRestServiceResource {

    private GradeRepository gradeRepository;

    public GradeRestServiceResource(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @PostMapping
    public Grade saveGrade(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteGrade(@PathVariable Long id) {
        Optional<Grade> result = gradeRepository.findById(id);
        if (result.isPresent()) {
            gradeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Grade> findAllGrade() {
        return gradeRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Grade findById(@PathVariable Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<Grade> findGradeByName(@PathVariable String name) {
        return gradeRepository.findByNameContaining(name);
    }
}
