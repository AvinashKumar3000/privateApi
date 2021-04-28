package com.example.project.controller;

import com.example.project.entity.Industry;
import com.example.project.entity.Lob;
import com.example.project.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IsuController {
    @Autowired
    private IndustryService service;
    @GetMapping("/isu")
    public List<Industry> getAllIndustries(){
        return service.listIndustries();
    }
    @GetMapping("/isu/{name}")
    public List<Lob> getAll(@PathVariable String name){
        return service.listLobByQuery(name);
    }
    @GetMapping("/isuById/{id}")
    public List<Lob> getAl(@PathVariable int id){
        return service.listLobByIdQuery(id);
    }

    @PostMapping("/isu")
    public Industry save(@RequestBody Industry domain){
        return service.saveIndustry(domain);
    }
    @PostMapping("/saveAllIsu")
    public List<Industry> saveAll(@RequestBody List<Industry> domains){
        return service.saveAllIndustries(domains);
    }
}
