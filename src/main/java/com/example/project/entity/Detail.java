package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Lob;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "poc_detail")
public class Detail {
    @Id
    @GeneratedValue
    private int detail_id;
    @Lob
    @Column(name="architecture_diagram")
    private String architecture;
    @Column(name="associates_contributing")
    private int associatesContributingToPOCs;
    @OneToMany(targetEntity = Benefit.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "db_bk", referencedColumnName = "detail_id")
    private List<Benefit> benefits;
    @OneToMany(targetEntity = Feature.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "db_fk", referencedColumnName = "detail_id")
    private List<Feature> features;
    @Lob
    @Column(name = "brm_cp")
    private String brmorCP;
    @Lob
    @Column(name = "code_reference")
    private String codeReference;
    @Lob
    @Column(name = "contextual_master")
    private String contextualMaster;
    @Lob
    @Column(name = "crm_id")
    private String crm;
    @Lob
    @Column(name = "customer_account")
    private String custAccount;
    @Lob
    @Column(name = "demo_video")
    private String demoVideoOrImage;
    @Lob
    @Column(name = "domain")
    private String domain;
    @Column(name = "end_date")
    private Date endDate;
    @Lob
    @Column(name = "g_and_t_story")
    private String story;
    @Lob
    @Column(name = "innovation_category")
    private String innoCategory;
    @Lob
    @Column(name = "innovista_Champion")
    private String innovistaChampion;
    @Column(name = "kpi")
    private String KPI[];
    @Lob
    @Column(name = "lob")
    private String LOB;
    @Column(name = "personas")
    private String personas[];
    @Lob
    @Column(name = "pov")
    private String pov;
    @Lob
    @Column(name = "problem_details")
    private String problemDetails;
    @Lob
    @Column(name = "product_owners")
    private String productOwners;
    @Lob
    @Column(name = "product_type")
    private String productType;
    @Column(name = "start_date")
    private Date startDate;
    @Lob
    @Column(name = "status")
    private String status;
    @Column(name = "tag")
    private String tag[];
    @Lob
    @Column(name = "tcs_solution")
    private String solution;
    @Lob
    @Column(name = "technology")
    private String[] techStack;
    @Lob
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "top_prospective_customers")
    private String topProspectiveCustomers;
    @Lob
    @Column(name = "crowd_sourcing_champion")
    private String crowdSourcingChampionOrDP;
    @Lob
    @Column(name = "ISU")
    private String isu;
    @Lob
    @Column(name = "sub_isu")
    private String subIsu;
    @Lob
    @Column(name = "github")
    private String github;
    @Lob
    @Column(name = "screenShot")
    private String screenShot;
    @Lob
    @Column(name = "tpc")
    private String TPC;
}


