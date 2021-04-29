package com.example.project.controller;

import com.example.project.entity.AssetType;
import com.example.project.entity.DigitalStore;
import com.example.project.service.DigitalStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DigitalStoreController {
    @Autowired
    private DigitalStoreService service;

    @GetMapping("assettype")
    public List<AssetType> getAsset() {
        return service.getAsset();
    }
    @GetMapping("digitalstore")
    public List<DigitalStore> readData() {
        return service.getAllData();
    }
    @GetMapping("digitalstore/assettype/{type_id}")
    public List<DigitalStore> readByAssetType(@PathVariable int type_id){
        return service.getAllDataByType(type_id);
    }
    @GetMapping("digitalstore/{id}")
    public DigitalStore readDataById(@PathVariable int id){
        return service.getData(id);
    }
    @PostMapping("digitalstore")
    public DigitalStore createData(@RequestBody DigitalStore digitalStore) {
        return service.save(digitalStore);
    }
    @PutMapping("digitalstore")
    public void updateData(@RequestBody DigitalStore digitalStore){
        service.editData(digitalStore);
    }
    @DeleteMapping("digitalstore/{id}")
    public void deleteData(@PathVariable int id){
        service.removeData(id);
    }
}
