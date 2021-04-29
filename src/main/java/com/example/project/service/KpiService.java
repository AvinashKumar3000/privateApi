package com.example.project.service;

import com.example.project.entity.Kpi;
import com.example.project.repository.KpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KpiService {
    @Autowired
    private KpiRepository repository;

    // Save
    @Caching(evict = {
            @CacheEvict(value = "kpi",allEntries = true)
    })
    public Kpi saveKpi(Kpi kpi){
        return repository.save(kpi);
    }
    public List<Kpi> saveAllKpis(List<Kpi> kpis){
        return repository.saveAll(kpis);
    }
    // get
    @Cacheable("kpi")
    public List<Kpi> listKpi(){
        return repository.findAll();
    }

}
