package com.example.vea.api.rest.controller;

import com.example.vea.model.Project;
import com.example.vea.service.ProjectServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {

    @Autowired
    private ProjectServiceJpa projectServiceJpa;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    Project findById(@PathVariable Integer id) {
        return projectServiceJpa.findById(id);
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    String save(@RequestBody Project project) {
        projectServiceJpa.save(project);
        return "SUCCESS";
    }

    @RequestMapping(value = "/project", method = RequestMethod.PUT)
    Project update(@RequestBody Project project) {
        return projectServiceJpa.save(project);
    }

    @RequestMapping(value = "/project", method = RequestMethod.DELETE)
    Map<String, String> delete(@RequestParam Integer id) {
        Map<String, String> status = new HashMap<>();
        Project project = projectServiceJpa.findById(id);
        if (project != null) {
            projectServiceJpa.delete(project.getId());
            status.put("Status", "Project deleted successfully");
        } else {
            status.put("Status", "Project not exist");
        }

        return status;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    List<Project> getAll() {
        return projectServiceJpa.getAll();
    }
}
