package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "digital_store")
public class DigitalStore {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String asset;
    private String tags[];
    private int detail_id;
    private int asset_type;
}

