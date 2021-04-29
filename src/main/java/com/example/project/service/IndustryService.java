package com.example.project.service;

import com.example.project.entity.Industry;
import com.example.project.entity.Lob;
import com.example.project.repository.LobRepository;
import com.example.project.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryService {
    @Autowired
    private IndustryRepository repository;
    @Autowired
    private LobRepository lobRepository;
    // get
    @Cacheable("industry")
    public List<Industry> listIndustries(){
        return repository.findAll();
    }
    public List<Lob> listLobByQuery(String name) {
        Industry industry = repository.findByName(name);
        if(industry != null){
            return lobRepository.findByIndustryId(industry.getId());
        }
        return null;
    }
    public List<Lob> listLobByIdQuery(int domainId) {
        return lobRepository.findByIndustryId(domainId);
    }
    // save
    @Caching(evict = {
            @CacheEvict(value = "industry",allEntries = true)
    })
    public Industry saveIndustry(Industry domain){
        return repository.save(domain);
    }
    public List<Industry> saveAllIndustries(List<Industry> domains){
        return repository.saveAll(domains);
    }
}
