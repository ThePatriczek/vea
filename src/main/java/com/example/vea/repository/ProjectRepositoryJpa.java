package com.example.vea.repository;

import com.example.vea.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepositoryJpa extends JpaRepository<Project, Integer> {
}
