package com.example.vea.mapper;

import com.example.vea.model.Company;
import com.example.vea.model.Developer;
import com.example.vea.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperMapper implements RowMapper<Developer> {
    @Override
    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Developer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("language"),
                new Company(rs.getInt("company_id")),
                new Project(rs.getInt("project_id"))
        );
    }
}