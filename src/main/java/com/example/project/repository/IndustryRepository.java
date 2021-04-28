package com.example.project.repository;

import com.example.project.entity.Industry;
import com.example.project.entity.Lob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryRepository extends JpaRepository<Industry,Integer> {
    Industry findByName(String inputName);

}
