package com.example.vea.repository;

import com.example.vea.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepositoryJpa extends JpaRepository<Developer, Integer>{
}
