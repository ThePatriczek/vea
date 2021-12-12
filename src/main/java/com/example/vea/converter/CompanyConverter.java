package com.example.vea.converter;

import com.example.vea.model.Company;
import com.example.vea.service.CompanyServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter implements Converter<String, Company> {

    @Autowired
    private CompanyServiceJpa companyServiceJpa;

    @Override
    public Company convert(String s) {
        return companyServiceJpa.findById(Integer.parseInt(s));

    }
}
