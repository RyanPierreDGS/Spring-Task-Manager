package com.portfolio.apryan.taskmanager.controller;

import com.portfolio.apryan.taskmanager.model.Profile;
import com.portfolio.apryan.taskmanager.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public Profile criar(@RequestBody Profile profile){
        return profileRepository.save(profile);
    }

    @GetMapping
    public List<Profile> listarTodos(){
        return profileRepository.findAll();
    }

}
