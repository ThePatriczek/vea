package com.example.vea.service;

import com.example.vea.model.Employee;
import com.example.vea.repository.EmployeeRepositoryJpa;
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
public class EmployeeServiceJpa implements BaseService<Employee> {

    @Autowired
    private EmployeeRepositoryJpa employeeRepositoryJpa;

    public List<Employee> getAll() {
        return employeeRepositoryJpa.findAll();
    }

    @Transactional
    public Employee save(Employee developer) {
        employeeRepositoryJpa.save(developer);
        return developer;
    }

    public Employee findById(Integer id) {
        return employeeRepositoryJpa.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
        employeeRepositoryJpa.deleteById(id);
    }
}
