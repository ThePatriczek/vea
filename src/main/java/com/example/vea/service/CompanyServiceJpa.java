package com.example.vea.service;

import com.example.vea.model.Company;
import com.example.vea.repository.CompanyRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@ConditionalOnProperty(
        value = "accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class CompanyServiceJpa implements BaseService<Company> {

    @Autowired
    private CompanyRepositoryJpa companyRepositoryJpa;

    public List<Company> getAll() {
        return companyRepositoryJpa.findAll();
    }

    @Transactional
    public Company save(Company developer) {
        companyRepositoryJpa.save(developer);
        return developer;
    }

    public Company findById(Integer id) {
        return companyRepositoryJpa.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Integer id) {
        companyRepositoryJpa.deleteById(id);
    }

    public Company findByName(String name) {
        return companyRepositoryJpa.findByName(name);
    }
}
