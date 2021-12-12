package com.example.vea.service;

import com.example.vea.model.Developer;
import com.example.vea.repository.DeveloperRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@ConditionalOnProperty(
        value = "accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class DeveloperServiceJpa implements BaseService<Developer> {

    @Autowired
    private DeveloperRepositoryJpa developerRepositoryJpa;

    public List<Developer> getAll() {
        return developerRepositoryJpa.findAll();
    }

    @Transactional
    public Developer save(Developer developer) {
        developerRepositoryJpa.save(developer);
        return developer;
    }

    public Developer findById(Integer id) {
        return developerRepositoryJpa.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
        developerRepositoryJpa.deleteById(id);
    }
}
