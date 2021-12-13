package com.example.vea.repository;

import com.example.vea.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryJpa extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
}
