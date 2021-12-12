package com.example.vea.repository;

import com.example.vea.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryJpa extends JpaRepository<Employee, Integer> {
}
