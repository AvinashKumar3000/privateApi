package com.example.project.service;

import com.example.project.entity.Benefit;
import com.example.project.entity.Detail;
import com.example.project.repository.BenefitRepository;
import com.example.project.repository.DetailRepository;
import com.example.project.repository.DigitalStoreRepository;
import com.example.project.repository.FeatureRepository;
import com.example.project.resource.ArrayInput;
import com.example.project.resource.CountClass;
import com.example.project.resource.FilterInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class DetailService {
    @Autowired
    private DetailRepository repository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private BenefitRepository benefitRepository;
    // POST
    @Caching(evict = {
            @CacheEvict(value = "detail",allEntries = true),
            @CacheEvict(value = "count",allEntries = true)})
    public Detail saveDetail(Detail detail) {
        return repository.save(detail);
    }
    // GET
    @Cacheable("detail")
    public List<Detail> listDetails() {
        return repository.findAllByOrderByIdDesc();
    }
    public List<Detail> searchByIndustry(String domainName) {
        return repository.findByDomain(domainName);
    }

    public List<Detail> searchByPersona(String persona) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>() ;

        for (Detail detail:details) {
            String[] arr = detail.getPersonas();
            for(String str:arr){
                if(str.equalsIgnoreCase(persona)){
                    list.add(detail);
                }
            }

        }
        return list;
    }
    public Detail searchById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Detail searchByTitle(String title){
        return repository.findByTitle(title);
    }
    // UPDATE
    @Caching(evict = {
            @CacheEvict(value = "detail",allEntries = true)})
    public Detail updateDetail(Detail newDetail) {
        Detail existingDetail = repository.findById(newDetail.getDetail_id()).orElse(null);
        existingDetail = newDetail;
        return repository.save(existingDetail);
    }
    // DELETE
    @Caching(evict = {
            @CacheEvict(value = "detail",allEntries = true),
            @CacheEvict(value = "count",allEntries = true)})
    public void deleteDetail(int id){
        Detail detail = repository.findByDetail_id(id);
        repository.delete(detail);
    }
    // get
    public List<Detail> searchByTechnology(String tech) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>() ;
        for (Detail detail:details) {
            String[] arr = detail.getTechStack();
            for(String str:arr){
                if(str.equalsIgnoreCase(tech)){
                    list.add(detail);
                }
            }
        }
        return list;
    }

    public List<Detail> searchByKpi(String kpi) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>() ;
        for (Detail detail:details) {
            String[] arr = detail.getKPI();
            for(String str:arr){
                if(str.equalsIgnoreCase(kpi)){
                    list.add(detail);
                }
            }
        }
        return list;
    }
    public List<Detail> searchByTag(String tag) {
        List<Detail> details = repository.findAll();
        ArrayList<Detail> list = new ArrayList<Detail>() ;
        for (Detail detail:details) {
            String[] arr = detail.getTag();
            for(String str:arr){
                if(str.equalsIgnoreCase(tag)){
                    list.add(detail);
                }
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

    public List<Detail> listDetail() {
        return repository.findAll();
    }

    public List<Detail> searchByIsu(String isu) {
        return repository.findAllByIsu(isu);
    }

    public List<Detail> searchBySubIsu(String subisu) {
        return repository.findAllBySubIsu(subisu);
    }

    public boolean inArray(String []arr, String value){
        if(value != null){
            for(String str:arr){
                if(str.equalsIgnoreCase(value)){
                    return true;
                }
            }
        }
        return false;
    }
    public List<Detail> filter(FilterInput filterInput) {
        List<Detail> details = repository.findAllByOrderByIdDesc();
        if(filterInput.isAllNull()){
            return details;
        }
        ArrayList<Detail> list = new ArrayList<Detail>() ;

        for (Detail detail:details) {
            boolean domainStatus = filterInput.getDomain() != null && detail.getDomain().equalsIgnoreCase(filterInput.getDomain());
            boolean personaStatus = inArray(detail.getPersonas(),filterInput.getPersona());
            boolean techStatus = inArray(detail.getTechStack(),filterInput.getTechnology());
            boolean tagStatus = inArray(detail.getTag(),filterInput.getTag());

            if( domainStatus || personaStatus || techStatus || tagStatus ) {
                list.add(detail);
            }
        }
        return list;
    }

    @Cacheable("count")
    public CountClass getCounts() {
        CountClass countClass = new CountClass();
        countClass.setTotal(repository.getTotalCount());
        countClass.setGe(repository.getTotalIsuCount("GE"));
        countClass.setBfsi(repository.getTotalIsuCount("BFSI"));
        countClass.setDTLI(repository.getTotalSubIsuCount("DTLI"));
        countClass.setDI(repository.getTotalSubIsuCount("DI"));
        countClass.setHealthCare_BH(repository.getTotalSubIsuCount("HealthCare & BH"));
        countClass.setGE_Engineeringprivate(repository.getTotalSubIsuCount("GE Engineering"));
        countClass.setCapital_Market_1(repository.getTotalSubIsuCount("Capital Market-I"));
        countClass.setCapital_Market_2(repository.getTotalSubIsuCount("Capital Market-II"));
        countClass.setCapital_Region(repository.getTotalSubIsuCount("Large Bank/Mortgage"));
        countClass.setMid_Atlantic(repository.getTotalSubIsuCount("Mid-Atlantic"));
        countClass.setNew_England(repository.getTotalSubIsuCount("New England"));
        countClass.setPA_MI(repository.getTotalSubIsuCount("PA & MI"));
        countClass.setMid_West(repository.getTotalSubIsuCount("Mid-West"));
        countClass.setDigital(repository.getTotalSubIsuCount("Digital"));
        return countClass;
    }

    public List<Detail> getByArray(ArrayInput arrayInput) {
        int[] ids = arrayInput.getIds();
        ArrayList<Detail> li = new ArrayList<Detail>();
        for(int id:ids) {
            Detail detail = repository.findById(id).orElse(null);
            if(detail != null) {
                li.add(detail);
            }
        }
        return li;
    }

    public List<Detail> recommendation(int detail_id){
        System.out.println("recommendation api called"); // testing purpose
        // consider detail_id = 455
        Detail detail = repository.findById(detail_id).orElse(null);

        if(detail != null){ // found detail
            System.out.println("recommendation algo started");
            String[] toSearchPersona = detail.getPersonas();
            String[] toSearchKpi = detail.getKPI();

            List<Detail> details = this.listDetails(); // get all list of details...
            ArrayList<int[]> items = new ArrayList<int[]>(); // [[idx,score],[detail_id,5],[1,4] ]
            // storing pairs as [detail_id,score]
            for(int i=0;i<details.size();i++) {
                Detail detail1 = details.get(i);
                if(detail1.getDetail_id() == detail.getDetail_id())
                    continue;

                int score = 0;
                // persona
                String[] toSearchInPersona = detail1.getPersonas();
                for(String value:toSearchPersona) {
                    if(inArray(toSearchInPersona,value)){
                        score++;
                    }
                }
                // persona
                String[] toSearchInKpi = detail1.getKPI();
                for(String value:toSearchKpi) {
                    if(inArray(toSearchInKpi,value)){
                        score++;
                    }
                }
                int[] result = new int[]{i,score};
                items.add(result);
            }
            List<Integer> idList = this.getTop(items); // we will get
            // top 5
            ArrayList<Detail> finalResult = new ArrayList<Detail>();
            for(Integer idx:idList){
                finalResult.add(details.get(idx)); // 
            }
            return finalResult;
        }
        return null;
    }

    private List<Integer> getTop(ArrayList<int[]> items) {
        // [ [idx,score] [] ] = > [score,score] // [3,5,2,1] => [5,3,2,1]
        ArrayList<Integer> idList = new ArrayList<Integer>();
        int length = items.size();
        Integer[] arr = new Integer[length];
        for(int i=0;i<length;i++){
            int[] temp = items.get(i);
            arr[i] = temp[1];
        }
        Arrays.sort(arr, Collections.reverseOrder()); // sorted desc order
        // arr = [desc..]
        // top5 score [] if in
        int limit = 5;
        int top = 0;
        for(int j = 0 ; j < arr.length ; j++) {
            if( limit == 0 || ( 10 - limit ) == items.size()) { // if limit exceeds
                break;
            }
            for(int i=0;i<items.size();i++){
                if( limit == 0) { // if limit exceeds
                    break;
                }
                int[] item = items.get(i);
                if(item[1] == arr[j]) { // item.score == highest score
                    // then add idx to the idList
                    idList.add(item[0]);
                    limit--;
                }
            }
        }
        return idList;
    }
}

