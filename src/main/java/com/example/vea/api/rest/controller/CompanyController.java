package com.example.vea.api.rest.controller;

import com.example.vea.model.Company;
import com.example.vea.service.CompanyServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CompanyController {

    @Autowired
    private CompanyServiceJpa companyServiceJpa;

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    Company findById(@PathVariable Integer id){
        return  companyServiceJpa.findById(id);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    String save(@RequestBody Company company){
        companyServiceJpa.save(company);
        return "SUCCESS";
    }

    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    Company update(@RequestBody Company developer){
        return companyServiceJpa.save(developer);
    }

    @RequestMapping(value = "/company", method = RequestMethod.DELETE)
    Map<String, String> delete(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Company company = companyServiceJpa.findById(id);
        if(company != null){
            companyServiceJpa.delete(company.getId());
            status.put("Status", "Company deleted successfully");
        }
        else {
            status.put("Status", "Company not exist");
        }

        return status;
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    List<Company> getAll(){
        return companyServiceJpa.getAll();
    }
}
