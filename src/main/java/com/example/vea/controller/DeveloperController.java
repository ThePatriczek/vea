package com.example.vea.controller;

import com.example.vea.model.Developer;
import com.example.vea.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @RequestMapping(value = "/developer/{id}", method = RequestMethod.GET)
    Developer getDeveloper(@PathVariable Integer id){
        return  developerService.findById(id).get();
    }

    @RequestMapping(value = "/developer", method = RequestMethod.POST)
    String addDeveloper(@RequestBody Developer developer){
        developerService.save(developer);
        return "SUCCESS";
    }

    @RequestMapping(value = "/developer", method = RequestMethod.PUT)
    Developer updateDeveloper(@RequestBody Developer developer){
        return developerService.save(developer);
    }

    @RequestMapping(value = "/developer", method = RequestMethod.DELETE)
    Map<String, String> deleteDeveloper(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Developer> developer = developerService.findById(id);
        if(developer.isPresent()) {
            developerService.delete(developer.get());
            status.put("Status", "Developer deleted successfully");
        }
        else {
            status.put("Status", "Developer not exist");
        }
        return status;
    }

    @RequestMapping(value = "/developers", method = RequestMethod.GET)
    List<Developer> getAllDevelopers(){
        return developerService.findAll();
    }

    @RequestMapping(value = "/developers", method = RequestMethod.POST)
    String addAllDevelopers(@RequestBody List<Developer> employeeList){
        developerService.saveAll(employeeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/developers", method = RequestMethod.DELETE)
    String addAllDevelopers(){
        developerService.deleteAll();
        return "SUCCESS";
    }
}
