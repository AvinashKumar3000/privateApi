package com.example.project.service;

import com.example.project.entity.*;
import com.example.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropDownService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private TopCustomersRepository topCustomersRepository;
    @Autowired
    private IsuRepo isuRepo;
    @Autowired
    private SubIsuRepo subIsuRepo;
    @Autowired
    private InnoCategoryRepo innoCategoryRepo;

    // get
    @Cacheable("product_type")
    public List<ProductType> getProductType(){
        return productTypeRepository.findAll();
    }
    @Cacheable("status")
    public List<Status> getStatus(){
        return statusRepository.findAll();
    }
    @Cacheable("top_customers")
    public List<TopCustomers> getTopCustomers(){
        return topCustomersRepository.findAll();
    }
    @Cacheable("inno_cat")
    public List<InnoCategory> getInnoCategory(){
        return innoCategoryRepo.findAll();
    }
}
