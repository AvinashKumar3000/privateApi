package com.example.project.service;

import com.example.project.entity.DigitalStore;
import com.example.project.repository.DigitalStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Service
public class DigitalStoreService {
    @Autowired
    private DigitalStoreRepository repository;
    @Caching(evict = {
            @CacheEvict(value = "digital_store",allEntries = true)})
    public DigitalStore save(DigitalStore digitalStore){
        return repository.save(digitalStore);
    }
    @Cacheable("digital_store")
    public List<DigitalStore> get() {
        return repository.findAll();
    }
//    public List<DigitalStore> queryExecution(int dtl_id) {
//        return repository.queryExecution(dtl_id);
//    }
}
