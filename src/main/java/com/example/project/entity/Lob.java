package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="lob")
public class Lob {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(name="industry_id")
    private int industryId;
}
