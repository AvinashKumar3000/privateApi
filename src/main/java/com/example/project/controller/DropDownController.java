package com.example.project.controller;

import com.example.project.entity.*;
import com.example.project.service.DropDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DropDownController {
    @Autowired
    private DropDownService service;

    @GetMapping("/product-type")
    public List<ProductType> get1() {
        return service.getProductType();
    }
    @GetMapping("/status")
    public List<Status> get2() {
        return service.getStatus();
    }
    @GetMapping("/top-customers")
    public List<TopCustomers> get3() {
        return service.getTopCustomers();
    }

    @GetMapping("/inno-category")
    public List<InnoCategory> get6() {
        return service.getInnoCategory();
    }
}
