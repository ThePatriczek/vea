package com.example.vea.service;

import com.example.vea.model.Project;
import com.example.vea.repository.ProjectRepositoryJpa;
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
public class ProjectServiceJpa implements BaseService<Project> {

    @Autowired
    private ProjectRepositoryJpa projectRepositoryJpa;

    public List<Project> getAll() {
        return projectRepositoryJpa.findAll();
    }

    @Transactional
    public Project save(Project project) {
        projectRepositoryJpa.save(project);
        return project;
    }

    public Project findById(Integer id) {
        return projectRepositoryJpa.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
        projectRepositoryJpa.deleteById(id);
    }

    public Project findByName(String name) {
        return projectRepositoryJpa.findByName(name);
    }
}
