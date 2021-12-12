package com.example.vea;

import com.example.vea.service.CompanyServiceJdbc;
import com.example.vea.service.DeveloperServiceJdbc;
import com.example.vea.service.EmployeeServiceJdbc;
import com.example.vea.service.ProjectServiceJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public DeveloperServiceJdbc developerServiceJdbc() {
        return new DeveloperServiceJdbc();
    }

    @Bean
    public CompanyServiceJdbc companyServiceJdbc() {
        return new CompanyServiceJdbc();
    }

    @Bean
    public EmployeeServiceJdbc employeeServiceJdbc() {
        return new EmployeeServiceJdbc();
    }

    @Bean
    public ProjectServiceJdbc projectServiceJdbc() {
        return new ProjectServiceJdbc();
    }
}