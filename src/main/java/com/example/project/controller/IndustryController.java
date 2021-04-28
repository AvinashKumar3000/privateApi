package com.example.project.controller;

import com.example.project.entity.Industry;
import com.example.project.entity.Lob;
import com.example.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IndustryController {
    @Autowired
    private IndustryService service;
    @GetMapping("/domain")
    public List<Industry> getAllIndustries(){
        return service.listIndustries();
    }
    @GetMapping("/domain/{name}")
    public List<Lob> getAll(@PathVariable String name){
        return service.listLobByQuery(name);
    }
    @GetMapping("/domainById/{id}")
    public List<Lob> getAl(@PathVariable int id){
        return service.listLobByIdQuery(id);
    }

    @PostMapping("/domain")
    public Industry save(@RequestBody Industry domain){
        return service.saveIndustry(domain);
    }
    @PostMapping("/saveAllDomain")
    public List<Industry> saveAll(@RequestBody List<Industry> domains){
        return service.saveAllIndustries(domains);
    }
}
