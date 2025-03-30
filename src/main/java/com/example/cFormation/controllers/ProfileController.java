package com.example.cFormation.controllers;

import com.example.cFormation.models.Profile;
import com.example.cFormation.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public Optional<Profile> getProfileById(@PathVariable int id) {
        return profileService.getProfileById(id);
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable int id) {
        profileService.deleteProfile(id);
    }
}
