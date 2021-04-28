package com.example.project.repository;

import com.example.project.entity.Lob;
import com.example.project.entity.SubIsu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubIsuRepo extends JpaRepository<SubIsu, Integer> {
    @Query(name = "SELECT * FROM sub_isu WHERE isu_id = :isuId")
    List<Lob> findByIsuId(@Param("isuId") int isuId);
}
