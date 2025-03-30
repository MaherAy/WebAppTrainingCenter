package com.example.cFormation.controllers;

import com.example.cFormation.models.Domaine;
import com.example.cFormation.services.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domaines")  // Changé de "/profiles" à "/domaines"
public class DomaineController {  // Renommé de ProfileController à DomaineController

    @Autowired
    private DomaineService domaineService;  // Changé de profileService à domaineService

    @GetMapping
    public List<Domaine> getAllDomaines() {  // Renommé et type retour changé
        return domaineService.getAllDomaines();
    }

    @GetMapping("/{id}")
    public Optional<Domaine> getDomaineById(@PathVariable int id) {  // Renommé et type retour changé
        return domaineService.getDomaineById(id);
    }

    @PostMapping
    public Domaine createDomaine(@RequestBody Domaine domaine) {  // Renommé et type paramètre changé
        return domaineService.createDomaine(domaine);
    }

    @DeleteMapping("/{id}")
    public void deleteDomaine(@PathVariable int id) {  // Renommé
        domaineService.deleteDomaine(id);
    }
}