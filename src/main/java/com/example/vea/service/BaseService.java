package com.example.vea.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {
    List<T> getAll();

    T save(T developer);

    T findById(Integer id);

    void delete(Integer id);
}
