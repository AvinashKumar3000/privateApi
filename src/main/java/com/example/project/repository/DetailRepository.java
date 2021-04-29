package com.example.project.repository;

import com.example.project.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
    Detail findByTitle(String title);
    List<Detail> findByDomain(String domain);
    List<Detail> findByLOB(String lob);

    @Query(value = "SELECT * FROM `poc_details` WHERE start_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
    List<Detail> startDateRange(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
    @Query(value = "SELECT * FROM `poc_details` WHERE start_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
    List<Detail> endDateRange(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

    @Query(value = "SELECT ISU,crowd_sourcing_champion, CONCAT ( YEAR(start_date), '-', CONCAT ( 'Q', Quarter(start_date) ) ) AS year_quarter, DENSE_RANK() OVER ( PARTITION BY ISU ORDER BY Concat ( YEAR(start_date), '-', CONCAT ( 'Q', Quarter(start_date) ) ) ) AS rank_ci, SUM( associates_contributing ) AS ASSOCIATES_CONTRI FROM poc_data group by ISU,crowd_sourcing_champion,start_date ORDER BY start_date",
    nativeQuery = true)
    List<Object> crowdQuery();

    @Query(value = "SELECT ISU,technology,\n" +
            "Concat (\n" +
            "\tYEAR(start_date)\n" +
            "    ,'-',\n" +
            "    CONCAT (\n" +
            "\t\t'Q',\n" +
            "        Quarter(start_date)\n" +
            "\t)\n" +
            ") AS Year_Quarter,\n" +
            "DENSE_RANK() OVER ( \n" +
            "\tPARTITION BY ISU \n" +
            "    ORDER BY \n" +
            "    Concat (\n" +
            "\t\tYEAR(start_date),\n" +
            "        '-',\n" +
            "        CONCAT (\n" +
            "\t\t\t'Q',\n" +
            "            Quarter(start_date)\n" +
            "            )\n" +
            "\t\t) ASC ) AS RANK_CI,\n" +
            "SUM(associates_contributing) AS ASSOCIATES_CONTRI\n" +
            "FROM poc_data\n" +
            "group by ISU,technology,start_date\n" +
            "ORDER BY start_date",
    nativeQuery = true)
    List<Object> dgTechQuery();

    @Query(value = "SELECT ISU,lob,\n" +
            "\tConcat (\n" +
            "\t\tYEAR(start_date),\n" +
            "        '-',\n" +
            "        CONCAT (\n" +
            "\t\t\t'Q',\n" +
            "            Quarter(start_date)\n" +
            "\t\t)\n" +
            "\t) AS Year_Quarter,\n" +
            "DENSE_RANK() OVER ( \n" +
            "\tPARTITION BY ISU\n" +
            "    ORDER BY Concat (\n" +
            "\t\tYEAR(start_date),\n" +
            "        '-',\n" +
            "        CONCAT (\n" +
            "\t\t\t'Q',\n" +
            "            Quarter(start_date)\n" +
            "\t\t)\n" +
            "\t) ASC \n" +
            ") AS RANK_CI,\n" +
            "SUM(associates_contributing) AS ASSOCIATES_CONTRI\n" +
            "FROM poc_data\n" +
            "group by ISU,lob,start_date\n" +
            "ORDER BY start_date\n",
    nativeQuery = true)
    List<Object> lobViewQuery();

    @Query(value = "SELECT ISU,Status,\n" +
            "\tConcat (\n" +
            "\t\tYEAR(start_date),\n" +
            "        '-',\n" +
            "        CONCAT (\n" +
            "\t\t\t'Q',\n" +
            "            Quarter(start_date)\n" +
            "\t\t)\n" +
            "\t) AS Year_Quarter,\n" +
            "DENSE_RANK() OVER ( \n" +
            "PARTITION BY ISU \n" +
            "ORDER BY Concat (\n" +
            "\tYEAR(start_date),\n" +
            "    '-',\n" +
            "    CONCAT (\n" +
            "\t\t'Q',\n" +
            "        Quarter(start_date)\n" +
            "\t)\n" +
            ") ASC ) AS RANK_CI,\n" +
            "SUM(associates_contributing) AS ASSOCIATES_CONTRI\n" +
            "FROM poc_data\n" +
            "group by ISU,status,start_date\n" +
            "ORDER BY start_date",
    nativeQuery = true)
    List<Object> pocStatusQuery();

    @Query(value = "DELETE FROM poc_detail where detail_id = :id",nativeQuery = true)
    int deleteByDetail_Id(@Param("id") int id);

    @Query(value = "SELECT * FROM poc_detail where detail_id = :id",nativeQuery = true)
    Detail findByDetail_id(@Param("id")int id);

    @Query(value = "SELECT * FROM poc_detail ORDER BY detail_id DESC",nativeQuery = true)
    List<Detail> findAllByOrderByIdDesc();
}
