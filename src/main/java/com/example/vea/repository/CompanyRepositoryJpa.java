package com.example.vea.repository;

import com.example.vea.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepositoryJpa extends JpaRepository<Company, Integer> {
}
