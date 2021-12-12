package com.example.vea.api.rest.controller;

import com.example.vea.model.Developer;
import com.example.vea.service.DeveloperServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeveloperController {

    @Autowired
    private DeveloperServiceJpa developerServiceJpa;

    @RequestMapping(value = "/developer/{id}", method = RequestMethod.GET)
    Developer findById(@PathVariable Integer id){
        return  developerServiceJpa.findById(id);
    }

    @RequestMapping(value = "/developer", method = RequestMethod.POST)
    String save(@RequestBody Developer developer){
        developerServiceJpa.save(developer);
        return "SUCCESS";
    }

    @RequestMapping(value = "/developer", method = RequestMethod.PUT)
    Developer update(@RequestBody Developer developer){
        return developerServiceJpa.save(developer);
    }

    @RequestMapping(value = "/developer", method = RequestMethod.DELETE)
    Map<String, String> delete(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Developer developer = developerServiceJpa.findById(id);
        if(developer != null){
            developerServiceJpa.delete(developer.getId());
            status.put("Status", "Developer deleted successfully");
        }
        else {
            status.put("Status", "Developer not exist");
        }

        return status;
    }

    @RequestMapping(value = "/developers", method = RequestMethod.GET)
    List<Developer> getAll(){
        return developerServiceJpa.getAll();
    }
}
