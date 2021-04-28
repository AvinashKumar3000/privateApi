package com.example.project.service;

import com.example.project.entity.Technology;
import com.example.project.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository repository;
    // get
    public List<Technology> getAll(){
        return repository.findAll();
    }
    // push
    public Technology addOne(Technology technology) {
        return repository.save(technology);
    }
    public List<Technology> addAll(List<Technology> technologies){
        return repository.saveAll(technologies);
    }
}
