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
        value="accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class DeveloperServiceJpa implements DeveloperService {

    @Autowired
    private DeveloperRepositoryJpa developerRepository;

    public List<Developer> getAll() {
        return developerRepository.findAll();
    }

    @Transactional
    public Developer save(Developer developer) {
        developerRepository.save(developer);
        return developer;
    }

    public Developer findById(Integer id) {
        return developerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
        developerRepository.deleteById(id);
    }
}
