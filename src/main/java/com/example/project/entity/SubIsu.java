package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sub_isu")
public class SubIsu {
    @Id
    @GeneratedValue
    private int id;
    private String value;
    @Column(name="isu_id")
    private int isuId;
}
