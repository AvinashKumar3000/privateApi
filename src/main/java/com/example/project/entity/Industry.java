package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Industry")
public class Industry {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    public String name;
}
