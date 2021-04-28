package com.example.project.repository;

import com.example.project.entity.TopCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopCustomersRepository extends JpaRepository<TopCustomers, Integer> {
}
