package com.example.vea.repository;

import com.example.vea.mapper.ProjectMapper;
import com.example.vea.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProjectRepositoryJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Project> getAll() {
        return jdbcTemplate.query("SELECT * FROM PROJECT", new ProjectMapper());
    }

    public Project findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PROJECT WHERE id = ?", new Object[]{id}, new ProjectMapper());
    }

    public void save(Project project) {
        if (project.getId() > 0) {
            jdbcTemplate.update("UPDATE PROJECT SET name = ?, company_id = ?, WHERE id = ?",
                    project.getName(), project.getCompany().getId(), project.getId());
        } else {
            jdbcTemplate.update("INSERT INTO PROJECT(name, company_id) VALUES(?, ?, ?)",
                    project.getName(), project.getCompany().getId());
        }

    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM PROJECT WHERE id = ?", id);
    }
}