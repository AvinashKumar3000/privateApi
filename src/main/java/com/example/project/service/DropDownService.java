package com.example.project.service;

import com.example.project.entity.*;
import com.example.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductType> getProductType(){
        return productTypeRepository.findAll();
    }
    public List<Status> getStatus(){
        return statusRepository.findAll();
    }
    public List<TopCustomers> getTopCustomers(){
        return topCustomersRepository.findAll();
    }
    public List<Isu> getIsu(){
        return isuRepo.findAll();
    }
    public List<SubIsu> getSubIsu(){
        return subIsuRepo.findAll();
    }
    public List<InnoCategory> getInnoCategory(){
        return innoCategoryRepo.findAll();
    }
}
