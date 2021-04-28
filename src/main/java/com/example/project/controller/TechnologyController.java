package com.example.project.controller;

import com.example.project.entity.Technology;
import com.example.project.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TechnologyController {
    @Autowired
    private TechnologyService service;
    @GetMapping("/tech")
    public List<Technology> getAll(){
        return service.getAll();
    }
    @PostMapping("/tech")
    public Technology get(@RequestBody Technology technology){
        return service.addOne(technology);
    }
    @PostMapping("/techAll")
    public List<Technology> addAll(@RequestBody List<Technology> technologies){
        return service.addAll(technologies);
    }

}
