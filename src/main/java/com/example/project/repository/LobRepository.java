package com.example.project.repository;

import com.example.project.entity.Lob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LobRepository extends JpaRepository<Lob,Integer> {
    @Query(name = "SELECT * FROM lob WHERE industry_id = :industryId")
    List<Lob> findByIndustryId(@Param("industryId") int industryId);
}
