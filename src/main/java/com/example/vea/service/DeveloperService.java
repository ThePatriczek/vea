package com.example.vea.service;

import com.example.vea.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperService extends JpaRepository<Developer, Integer>{
}
