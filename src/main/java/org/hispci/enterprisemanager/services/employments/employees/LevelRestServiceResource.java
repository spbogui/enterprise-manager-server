package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Level;
import org.hispci.enterprisemanager.repositories.employments.employees.LevelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/levels")
@RestController
public class LevelRestServiceResource {

    private LevelRepository levelRepository;

    public LevelRestServiceResource(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @PostMapping
    public Level saveLevel(@RequestBody Level level) {
        return levelRepository.save(level);
    }

    @PutMapping("/{id}")
    public Level updateLevel(@PathVariable Long id) {
        return levelRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteLevel(Long id) {
        Optional<Level> result = levelRepository.findById(id);
        if (result.isPresent()) {
            levelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Level> findAllLevel() {
        return levelRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Level findById(@PathVariable Long id) {
        return levelRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<Level> findLevelByName(@PathVariable String name) {
        return levelRepository.findByNameContaining(name);
    }

    @GetMapping("/children/{name}")
    public List<Level> findChildLevel(@PathVariable String name) {
        return levelRepository.findByParentLevel_Name(name);
    }

    @GetMapping("/other/{name}")
    public List<Level> findOtherLevel(@PathVariable String name) {
        Level level = levelRepository.findByName(name);
        List<Level> levelList = levelRepository.findAll();
        List<Level> result = new ArrayList<>();
        for (Level l :
                levelList) {
            if (!l.equals(level)) {
                result.add(l);
            }
        }
        return result.isEmpty() ? levelList : result;
    }
}
