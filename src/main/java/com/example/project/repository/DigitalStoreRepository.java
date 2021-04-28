package com.example.project.repository;

import com.example.project.entity.DigitalStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DigitalStoreRepository extends JpaRepository<DigitalStore, Integer> {
    @Query(value = "DELETE FROM digital_store where detail_id = :id",nativeQuery = true)
    int deletebyDetail_id(@Param("id") int id);
//    @Query(name = "",)
//    List<DigitalStore> queryExecution(int dtl_id);
}
