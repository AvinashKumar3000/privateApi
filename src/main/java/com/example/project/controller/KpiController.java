package com.example.project.controller;

import com.example.project.entity.Kpi;
import com.example.project.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KpiController {
    @Autowired
    private KpiService service;
    @GetMapping("/kpi")
    public List<Kpi> findAll() {
        return service.listKpi();
    }
    @PostMapping("/kpi")
    public Kpi save(@RequestBody Kpi kpi){
        return service.saveKpi(kpi);
    }
    @PostMapping("/saveAllKpis")
    public List<Kpi> saveAll(@RequestBody List<Kpi> kpis){
        return service.saveAllKpis(kpis);
    }
}
