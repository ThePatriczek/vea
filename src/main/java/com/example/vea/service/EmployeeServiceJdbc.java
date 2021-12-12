package com.example.vea.service;

import com.example.vea.model.Employee;
import com.example.vea.repository.EmployeeRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value = "accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class EmployeeServiceJdbc implements BaseService<Employee> {

    @Autowired
    EmployeeRepositoryJdbc employeeRepositoryJdbc;

    @Override
    public List<Employee> getAll() {
        return employeeRepositoryJdbc.getAll();
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepositoryJdbc.save(employee);
        return employee;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepositoryJdbc.findById(id);
    }

    @Override
    public void delete(Integer id) {
        employeeRepositoryJdbc.delete(id);
    }
}