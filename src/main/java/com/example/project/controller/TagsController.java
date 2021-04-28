package com.example.project.controller;

import com.example.project.entity.Tags;
import com.example.project.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TagsController {
    @Autowired
    private TagsService service;
    @GetMapping("/tags")
    public List<Tags> findAll() {
        return service.listTags();
    }
    @PostMapping("/tags")
    public Tags save(@RequestBody Tags tag) {
        return service.saveTag(tag);
    }
    @PostMapping("/saveAllTags")
    public List<Tags> saveAll(@RequestBody List<Tags> tags){
        return service.saveAllTags(tags);
    }
}
