package com.example.cFormation.services;
import com.example.cFormation.models.Domaine;
import com.example.cFormation.repositories.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomaineService {

    @Autowired
    private DomaineRepository domaineRepository;

    public List<Domaine> getAllDomaines() {
        return domaineRepository.findAll();
    }

    public Optional<Domaine> getDomaineById(int id) {
        return domaineRepository.findById(id);
    }

    public Domaine createDomaine(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    public void deleteDomaine(int id) {
        domaineRepository.deleteById(id);
    }
}