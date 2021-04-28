package com.example.project.service;

import com.example.project.entity.Tags;
import com.example.project.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsService {
    @Autowired
    private TagsRepository repository;

    // SAVE
    public Tags saveTag(Tags tag) {
        return repository.save(tag);
    }
    public List<Tags> saveAllTags(List<Tags> tags){
        return repository.saveAll(tags);
    }
    // GET
    public List<Tags> listTags() {
        return repository.findAll();
    }
}
