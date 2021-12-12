package com.example.vea.converter;

import com.example.vea.model.Developer;
import com.example.vea.service.DeveloperServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeveloperConverter implements Converter<String, Developer> {

    @Autowired
    private DeveloperServiceJpa developerService;

    @Override
    public Developer convert(String s) {
        return developerService.findById(Integer.parseInt(s));

    }
}
