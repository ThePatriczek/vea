package com.example.vea.service;

import com.example.vea.model.Developer;
import com.example.vea.repository.DeveloperRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value = "accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class DeveloperServiceJdbc implements DeveloperService {

    @Autowired
    DeveloperRepositoryJdbc developerRepositoryJdbc;

    @Override
    public List<Developer> getAll() {
        return developerRepositoryJdbc.getAll();
    }

    @Override
    public Developer save(Developer developer) {
        developerRepositoryJdbc.save(developer);
        return developer;
    }

    @Override
    public Developer findById(Integer id) {
        return developerRepositoryJdbc.findById(id);
    }

    @Override
    public void delete(Integer id) {
        developerRepositoryJdbc.delete(id);
    }
}