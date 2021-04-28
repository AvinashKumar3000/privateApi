package com.example.project.service;

import com.example.project.entity.Benefit;
import com.example.project.entity.Detail;
import com.example.project.repository.BenefitRepository;
import com.example.project.repository.DetailRepository;
import com.example.project.repository.DigitalStoreRepository;
import com.example.project.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DetailService {
    @Autowired
    private DetailRepository repository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private BenefitRepository benefitRepository;
    @Autowired
    private DigitalStoreRepository digitalStoreRepository;
    // POST
    public Detail saveDetail(Detail detail) {
        return repository.save(detail);
    }
    // GET
    public List<Detail> listDetails() {
        return repository.findAll();
    }
    public List<Detail> searchByIndustry(String domainName) {
        return repository.findByDomain(domainName);
    }

    public List<Detail> searchByLob(String lob) {
        return repository.findByLOB(lob);
    }
    public Detail searchById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Detail searchByTitle(String title){
        return repository.findByTitle(title);
    }
    // UPDATE
    public Detail updateDetail(Detail newDetail) {
        Detail existingDetail = repository.findById(newDetail.getDetail_id()).orElse(null);
        existingDetail = newDetail;
        return repository.save(existingDetail);
    }
    // DELETE
    public void deleteDetail(int id){
        // delete the rows in digit store table
        digitalStoreRepository.deletebyDetail_id(id);
        repository.deleteByDetail_Id(id);
    }
    // get
    public List<Detail> searchByTechnology(String tech) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>();
        for (Detail detail: details) {
            boolean foundStatus = Arrays.asList(detail.getTechStack()).contains(tech);
            if(foundStatus){
                list.add(detail);
            }
        }
        return list;
    }

    public List<Detail> searchByKpi(String kpi) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>();
        for (Detail detail: details) {
            boolean foundStatus = Arrays.asList(detail.getKPI()).contains(kpi);
            if(foundStatus){
                list.add(detail);
            }
        }
        return list;
    }
    public List<Detail> searchByTag(String tag) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>();
        for (Detail detail: details) {
            boolean foundStatus = Arrays.asList(detail.getTag()).contains(tag);
            if(foundStatus){
                list.add(detail);
            }
        }
        return list;
    }

    public List<Detail> startDate(String from, String to) {
        return repository.startDateRange(from, to);
    }

    public List<Detail> endDate(String from, String to) {
        return repository.endDateRange(from,to);
    }

    public List<Object> crowd() {
        return repository.crowdQuery();
    }

    public List<Object> dgTech() {
        return repository.dgTechQuery();
    }

    public List<Object> lobView() {
        return repository.lobViewQuery();
    }

    public List<Object> pocStatus() {
        return repository.pocStatusQuery();
    }

    public List<Detail> saveAllDetails(List<Detail> details) {
        return repository.saveAll(details);
    }
}
