package com.example.vea.service;

import com.example.vea.model.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    public List<Developer> getAll();
    public Developer save(Developer developer);
    public Developer findById(Integer id);
    public void delete(Integer id);
}
