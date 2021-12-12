package com.example.vea.api.rest.controller;

import com.example.vea.model.Employee;
import com.example.vea.service.EmployeeServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceJpa employeeServiceJpa;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    Employee findById(@PathVariable Integer id) {
        return employeeServiceJpa.findById(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    String save(@RequestBody Employee employee) {
        employeeServiceJpa.save(employee);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee update(@RequestBody Employee employee) {
        return employeeServiceJpa.save(employee);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    Map<String, String> delete(@RequestParam Integer id) {
        Map<String, String> status = new HashMap<>();
        Employee employee = employeeServiceJpa.findById(id);
        if (employee != null) {
            employeeServiceJpa.delete(employee.getId());
            status.put("Status", "Employee deleted successfully");
        } else {
            status.put("Status", "Employee not exist");
        }

        return status;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee> getAll() {
        return employeeServiceJpa.getAll();
    }
}
