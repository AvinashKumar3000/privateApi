package com.example.project.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterInput {
    private String domain;
    private String persona;
    private String tag;
    private String technology;
}
