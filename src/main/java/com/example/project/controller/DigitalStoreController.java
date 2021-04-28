package com.example.project.controller;

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
    @GetMapping("/digitalStore")
    public List<DigitalStore> getAll() {
        return service.get();
    }
    @PostMapping("/digitalStore")
    public DigitalStore save(@RequestBody DigitalStore digitalStore) {
        return service.save(digitalStore);
    }
}
