
package com.example.cFormation.services;
import com.example.cFormation.models.Structure;
import com.example.cFormation.repositories.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StructureService {

    @Autowired
    private StructureRepository structureRepository;

    public List<Structure> getAllStructures() {
        return structureRepository.findAll();
    }

    public Optional<Structure> getStructureById(int id) {
        return structureRepository.findById(id);
    }

    public Structure createStructure(Structure structure) {
        return structureRepository.save(structure);
    }

    public void deleteStructure(int id) {
        structureRepository.deleteById(id);
    }
}
