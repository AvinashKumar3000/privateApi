package com.example.project.service;

import com.example.project.entity.Persona;
import com.example.project.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repository;

    // post
    public Persona savePersona(Persona persona) {
        return repository.save(persona);
    }
    public List<Persona> saveAllPersonas(List<Persona> personas){
        return repository.saveAll(personas);
    }
    // Get
    public List<Persona> getPersonas(){
        return repository.findAll();
    }
}
