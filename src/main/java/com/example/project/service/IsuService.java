package com.example.project.service;

import com.example.project.entity.Isu;
import com.example.project.entity.Lob;
import com.example.project.repository.IsuRepo;
import com.example.project.repository.SubIsuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsuService {
    @Autowired
    private IsuRepo repository;
    @Autowired
    private SubIsuRepo subIsuRepo;
    // get
    public List<Isu> listIndustries(){
        return repository.findAll();
    }
    public List<Lob> listLobByQuery(String name) {
        Isu isu = repository.findByName(name);
        if(isu != null){
            return subIsuRepo.findByIsuId(isu.getId());
        }
        return null;
    }
    public List<Lob> listLobByIdQuery(int domainId) {
        return subIsuRepo.findByIsuId(domainId);
    }
    // save
    public Isu saveIsu(Isu domain){
        return repository.save(domain);
    }
    public List<Isu> saveAllIndustries(List<Isu> domains){
        return repository.saveAll(domains);
    }
}
