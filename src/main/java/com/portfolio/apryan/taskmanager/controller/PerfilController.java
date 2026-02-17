package com.portfolio.apryan.taskmanager.controller;

import com.portfolio.apryan.taskmanager.model.Perfil;
import com.portfolio.apryan.taskmanager.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    public Perfil criar(@RequestBody Perfil perfil){
        return perfilRepository.save(perfil);
    }

    @GetMapping
    public List<Perfil> listarTodos(){
        return perfilRepository.findAll();
    }

}
