package com.example.project.repository;

import com.example.project.entity.Isu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsuRepo extends JpaRepository<Isu,Integer> {
    Isu findByValue(String inputName);
}
