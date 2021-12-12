package com.example.vea.converter;

import com.example.vea.model.Employee;
import com.example.vea.service.EmployeeServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private EmployeeServiceJpa employeeServiceJpa;

    @Override
    public Employee convert(String s) {
        return employeeServiceJpa.findById(Integer.parseInt(s));

    }
}
