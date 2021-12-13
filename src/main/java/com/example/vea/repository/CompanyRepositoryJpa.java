package com.example.vea.repository;

import com.example.vea.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositoryJpa extends JpaRepository<Company, Integer> {
    Company findByName(String name);
}
