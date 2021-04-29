package com.example.project.service;

import com.example.project.entity.Isu;
import com.example.project.entity.Lob;
import com.example.project.entity.SubIsu;
import com.example.project.repository.IsuRepo;
import com.example.project.repository.SubIsuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsuService {
    @Autowired
    private IsuRepo repository;
    @Autowired
    private SubIsuRepo subIsuRepo;
    // get
    @Cacheable("isu")
    public List<Isu> listIsu(){
        return repository.findAll();
    }
    public List<SubIsu> listLobByQuery(String name) {
        Isu isu = repository.findByValue(name);
        if(isu != null){
            return subIsuRepo.findByIsuId(isu.getIsu_id());
        }
        return null;
    }
    public List<SubIsu> listByIdQuery(int domainId) {
        return subIsuRepo.findByIsuId(domainId);
    }
    // save
    @Caching(evict = {
            @CacheEvict(value = "isu",allEntries = true)
    })
    public Isu saveIsu(Isu domain){
        return repository.save(domain);
    }
    public List<Isu> saveAllIndustries(List<Isu> domains){
        return repository.saveAll(domains);
    }
}
