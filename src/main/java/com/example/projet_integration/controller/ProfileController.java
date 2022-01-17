package com.example.projet_integration.controller;

import com.example.projet_integration.dto.PostRequest;
import com.example.projet_integration.dto.ProfilRequest;
import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.Post;
import com.example.projet_integration.model.User;
import com.example.projet_integration.model.profile;
import com.example.projet_integration.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("/{username}")
    public profile getprofileByusername(@PathVariable("username") String username) {

        System.out.println("marietteeeee profilee " + profileRepository.findByUsername(username));
        return profileRepository.findByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody ProfilRequest profilRequest) {

        profile profile = profileRepository.findByUsername(profilRequest.getUsername());
        profile.setFullName(profilRequest.getFullName());
        profile.setEmail(profilRequest.getEmail());
        profile.setExperience(profilRequest.getExperience());
        profile.setJob(profilRequest.getJob());
        profile.setLocation(profile.getLocation());
        profile.setAbout_me(profile.getAbout_me());
        profile.setExperience(profile.getExperience());
        profile.setMobile(profile.getMobile());
        profile.setSkills(profile.getSkills());

        profileRepository.save(profile);

        System.out.println(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
