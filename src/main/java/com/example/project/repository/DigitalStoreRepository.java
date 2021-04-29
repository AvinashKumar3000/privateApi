package com.example.project.repository;

import com.example.project.entity.DigitalStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DigitalStoreRepository extends JpaRepository<DigitalStore, Integer> {
    @Query(value = "SELECT * from digital_store WHERE asset_type = :asset_id", nativeQuery = true)
    List<DigitalStore> findAllByAsset_type(@Param("asset_id") int asset_id);
    @Query(value = "SELECT * from digital_store where detail_id = :detail_id", nativeQuery = true)
    List<DigitalStore> findAllByDetail_id(int detail_id);
}
