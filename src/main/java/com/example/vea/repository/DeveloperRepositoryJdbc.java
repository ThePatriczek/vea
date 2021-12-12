package com.example.vea.repository;

import com.example.vea.mappers.DeveloperMapper;
import com.example.vea.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DeveloperRepositoryJdbc {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Developer> getAll() {
        return jdbcTemplate.query("SELECT * FROM DEVELOPER", new DeveloperMapper());
    }

    public Developer findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM DEVELOPER WHERE id = ?", new Object[]{id}, new DeveloperMapper());
    }

    public void save(Developer developer) {
        if (developer.getId() > 0) {
            jdbcTemplate.update("UPDATE DEVELOPER SET name = ?, language = ?, company_id = ?, WHERE id = ?",
                    developer.getName(), developer.getLanguage(), developer.getCompany().getId(), developer.getId());
        } else {
            jdbcTemplate.update("INSERT INTO DEVELOPER(name, language, company_id) VALUES('AUTHOR', ?, ?, ?)",
                    developer.getName(), developer.getLanguage(), developer.getCompany().getId());
        }

    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM DEVELOPER WHERE id = ?", id);
    }
}