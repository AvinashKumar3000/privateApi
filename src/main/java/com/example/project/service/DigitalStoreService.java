package com.example.project.service;

import com.example.project.entity.AssetType;
import com.example.project.entity.DigitalStore;
import com.example.project.repository.AssetTypeRepo;
import com.example.project.repository.DigitalStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DigitalStoreService {
    @Autowired
    private DigitalStoreRepository repository;
    @Autowired
    private AssetTypeRepo assetTypeRepo;
    @Cacheable("assettype")
    public List<AssetType> getAsset(){
        return assetTypeRepo.findAll();
    }
    // post
    @Caching(evict = {
            @CacheEvict(value = "digital_store",allEntries = true)})
    public DigitalStore save(DigitalStore digitalStore){
        return repository.save(digitalStore);
    }
    // get
    @Cacheable("digital_store")
    public List<DigitalStore> getAllData() {
        return repository.findAll();
    }
    public List<DigitalStore> getAllDataByType(int asset_id) {
        return repository.findAllByAsset_type(asset_id);
    }
    public DigitalStore getData(int id) {
        return repository.findById(id).orElse(null);
    }
    // put
    public void editData(DigitalStore digitalStore) {
        DigitalStore old = repository.findById(digitalStore.getId()).orElse(null);
        if(old != null) {
            old = digitalStore;
            repository.save(old);
        }
    }
    // delete
    public void removeData(int id){
        repository.deleteById(id);
    }
    public void removeByDetailId(int detail_id){
        List<DigitalStore> digitalStores = this.getAllDataByDetailId(detail_id);
        for (DigitalStore digitalStore: digitalStores) {
            repository.delete(digitalStore);
        }
    }
    // get by detail id
    private List<DigitalStore> getAllDataByDetailId(int detail_id) {
        return repository.findAllByDetail_id(detail_id);
    }
    // get Asset
}
