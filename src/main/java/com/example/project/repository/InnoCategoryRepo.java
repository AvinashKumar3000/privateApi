package com.example.project.repository;

import com.example.project.entity.InnoCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnoCategoryRepo extends JpaRepository<InnoCategory,Integer> {
}

