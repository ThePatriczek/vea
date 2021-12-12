package com.example.vea.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {
    public List<T> getAll();
    public T save(T developer);
    public T findById(Integer id);
    public void delete(Integer id);
}
