package com.example.vea.repository;

import com.example.vea.mapper.CompanyMapper;
import com.example.vea.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CompanyRepositoryJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Company> getAll() {
        return jdbcTemplate.query("SELECT * FROM COMPANY", new CompanyMapper());
    }

    public Company findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM COMPANY WHERE id = ?", new Object[]{id}, new CompanyMapper());
    }

    public void save(Company company) {
        if (company.getId() > 0) {
            jdbcTemplate.update("UPDATE COMPANY SET name = ? WHERE id = ?", company.getName());
        } else {
            jdbcTemplate.update("INSERT INTO COMPANY(name) VALUES(?, ?, ?)", company.getName());
        }

    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM COMPANY WHERE id = ?", id);
    }
}