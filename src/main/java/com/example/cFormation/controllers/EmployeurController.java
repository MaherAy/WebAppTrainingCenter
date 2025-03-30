package com.example.cFormation.controllers;

import com.example.cFormation.models.Employeur;
import com.example.cFormation.services.EmployeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeurs")
public class EmployeurController {

    @Autowired
    private EmployeurService employeurService;

    @GetMapping
    public List<Employeur> getAllEmployeurs() {
        return employeurService.getAllEmployeurs();
    }

    @GetMapping("/{id}")
    public Optional<Employeur> getEmployeurById(@PathVariable int id) {
        return employeurService.getEmployeurById(id);
    }

    @PostMapping
    public Employeur createEmployeur(@RequestBody Employeur employeur) {
        return employeurService.createEmployeur(employeur);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeur(@PathVariable int id) {
        employeurService.deleteEmployeur(id);
    }
}
