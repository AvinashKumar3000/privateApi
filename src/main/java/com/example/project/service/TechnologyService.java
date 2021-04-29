package com.example.project.service;

import com.example.project.entity.Technology;
import com.example.project.repository.TechnologyRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository repository;
    // get
    @Cacheable("tech")
    public List<Technology> getAll(){
        return repository.findAll();
    }
    // push
    @Caching(evict = {
            @CacheEvict(value = "tech",allEntries = true)
    })
    public Technology addOne(Technology technology) {
        return repository.save(technology);
    }
    public List<Technology> addAll(List<Technology> technologies){
        return repository.saveAll(technologies);
    }
}
