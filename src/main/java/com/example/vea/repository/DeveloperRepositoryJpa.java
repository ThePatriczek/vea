package com.example.vea.repository;

import com.example.vea.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepositoryJpa extends JpaRepository<Developer, Integer> {
    Developer findByName(String name);
}
