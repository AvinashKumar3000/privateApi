package com.example.project.repository;

import com.example.project.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTypeRepo extends JpaRepository<AssetType, Integer> {

}
