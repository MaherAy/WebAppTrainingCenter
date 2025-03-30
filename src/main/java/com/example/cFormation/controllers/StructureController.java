package com.example.cFormation.controllers;

import com.example.cFormation.models.Structure;
import com.example.cFormation.services.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/structures")
public class StructureController {

    @Autowired
    private StructureService structureService;

    @GetMapping
    public List<Structure> getAllStructures() {
        return structureService.getAllStructures();
    }

    @GetMapping("/{id}")
    public Optional<Structure> getStructureById(@PathVariable int id) {
        return structureService.getStructureById(id);
    }

    @PostMapping
    public Structure createStructure(@RequestBody Structure structure) {
        return structureService.createStructure(structure);
    }

    @DeleteMapping("/{id}")
    public void deleteStructure(@PathVariable int id) {
        structureService.deleteStructure(id);
    }
}
