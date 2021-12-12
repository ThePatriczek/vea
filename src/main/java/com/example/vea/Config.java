package com.example.vea;

import com.example.vea.converter.DeveloperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Autowired
    DeveloperConverter developerConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(developerConverter);
    }
}
