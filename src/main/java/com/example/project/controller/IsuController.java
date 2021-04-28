package com.example.project.controller;

import com.example.project.entity.Isu;
import com.example.project.entity.SubIsu;
import com.example.project.service.IsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IsuController {
    @Autowired
    private IsuService service;
    @GetMapping("/isu")
    public List<Isu> getAllIndustries(){
        return service.listIsu();
    }
    @GetMapping("/isu/{name}")
    public List<SubIsu> getAll(@PathVariable String name){
        return service.listLobByQuery(name);
    }
    @GetMapping("/isuById/{id}")
    public List<SubIsu> getAl(@PathVariable int id){
        return service.listByIdQuery(id);
    }


}
