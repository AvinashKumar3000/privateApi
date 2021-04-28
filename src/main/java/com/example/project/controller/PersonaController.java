package com.example.project.controller;

import com.example.project.entity.Persona;
import com.example.project.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private PersonaService service;
    @GetMapping("/persona")
    public List<Persona> findAll() {
        return service.getPersonas();
    }
    @PostMapping("/persona")
    public Persona save(@RequestBody Persona persona){
        return service.savePersona(persona);
    }
    @PostMapping("/saveAllPersonas")
    public List<Persona> saveAll(@RequestBody List<Persona> personas){
        return service.saveAllPersonas(personas);
    }
}
