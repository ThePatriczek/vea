package com.example.vea.service;

import com.example.vea.model.Company;
import com.example.vea.repository.CompanyRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value = "accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class CompanyServiceJdbc implements BaseService<Company> {

    @Autowired
    CompanyRepositoryJdbc companyRepositoryJdbc;

    @Override
    public List<Company> getAll() {
        return companyRepositoryJdbc.getAll();
    }

    @Override
    public Company save(Company developer) {
        companyRepositoryJdbc.save(developer);
        return developer;
    }

    @Override
    public Company findById(Integer id) {
        return companyRepositoryJdbc.findById(id);
    }

    @Override
    public void delete(Integer id) {
        companyRepositoryJdbc.delete(id);
    }
}