package com.example.vea.service;

import com.example.vea.model.Project;
import com.example.vea.repository.ProjectRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value = "accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class ProjectServiceJdbc implements BaseService<Project> {

    @Autowired
    ProjectRepositoryJdbc projectRepositoryJdbc;

    @Override
    public List<Project> getAll() {
        return projectRepositoryJdbc.getAll();
    }

    @Override
    public Project save(Project project) {
        projectRepositoryJdbc.save(project);
        return project;
    }

    @Override
    public Project findById(Integer id) {
        return projectRepositoryJdbc.findById(id);
    }

    @Override
    public void delete(Integer id) {
        projectRepositoryJdbc.delete(id);
    }
}