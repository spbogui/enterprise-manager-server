package org.hispci.enterprisemanager.services.activities;

import org.hispci.enterprisemanager.domain.activities.Structure;
import org.hispci.enterprisemanager.repositories.activities.StructureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StructureRestServiceResource {
    private final StructureRepository structureRepository;

    public StructureRestServiceResource(StructureRepository structureRepository) {
        this.structureRepository = structureRepository;
    }

    /******************************************************
     * ACTIVITY RESOURCES
     ******************************************************/

    /**
     * saveActivity()
     * @param structure
     * @return ActivityMember
     */
    @PostMapping("/members")
    public Structure save(Structure structure) {
        return structureRepository.save(structure);
    }

    /**
     * updateActivity()
     * @param structure
     * @return ActivityMember
     */
    @PutMapping("/structures")
    public Structure update(Structure structure) {
        return structureRepository.saveAndFlush(structure);
    }

    /**
     * remove()
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/structures/{id}")
    public Boolean remove(@PathVariable Long id) {
        Optional<Structure> result = structureRepository.findById(id);

        if (result.isPresent()) {
            structureRepository.deleteById(id);
            return true;
        }

        return false;
    }

    /**
     * findAll()
     * @return List<Activity>
     */
    @GetMapping("/structures")
    public List<Structure> findAll() {
        return structureRepository.findAll();
    }

    /**
     * getOne()
     * @param id
     * @return Activity
     */
    @GetMapping("/structures/{id}")
    public Structure getOne(@PathVariable Long id){
        return structureRepository.findById(id).orElse(null);
    }

}
