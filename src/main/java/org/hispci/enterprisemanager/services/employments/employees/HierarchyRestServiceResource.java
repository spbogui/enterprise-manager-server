package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Hierarchy;
import org.hispci.enterprisemanager.repositories.employments.employees.HierarchyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/hierarchies")
@RestController
public class HierarchyRestServiceResource {

    private HierarchyRepository hierarchyRepository;

    public HierarchyRestServiceResource(HierarchyRepository hierarchyRepository) {
        this.hierarchyRepository = hierarchyRepository;
    }

    @PostMapping
    public Hierarchy saveHierarchy(@RequestBody Hierarchy hierarchy) {
        return hierarchyRepository.save(hierarchy);
    }

    @PutMapping("/{id}")
    public Hierarchy updateHierarchy(@PathVariable Long id) {
        return hierarchyRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteHierarchy(Long id) {
        Optional<Hierarchy> result = hierarchyRepository.findById(id);
        if (result.isPresent()) {
            hierarchyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Hierarchy> findAllHierarchy() {
        return hierarchyRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Hierarchy findById(@PathVariable Long id) {
        return hierarchyRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<Hierarchy> findHierarchyByName(@PathVariable String name) {
        return hierarchyRepository.findByNameContaining(name);
    }

    @GetMapping("/children/{name}")
    public List<Hierarchy> findChildLevel(@PathVariable String name) {
        return hierarchyRepository.findByParentHierarchy_Name(name);
    }

    @GetMapping("/other/{name}")
    public List<Hierarchy> findOtherLevel(@PathVariable String name) {
        Hierarchy hierarchy = hierarchyRepository.findByName(name);
        List<Hierarchy> hierarchyList = hierarchyRepository.findAll();
        List<Hierarchy> result = new ArrayList<>();
        for (Hierarchy l :
                hierarchyList) {
            if (!l.equals(hierarchy)) {
                result.add(l);
            }
        }
        return result.isEmpty() ? hierarchyList : result;
    }
}
