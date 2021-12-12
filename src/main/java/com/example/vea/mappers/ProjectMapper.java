package com.example.vea.mappers;

import com.example.vea.model.Company;
import com.example.vea.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Project(
                rs.getInt("id"),
                rs.getString("name"),
                new Company(rs.getInt("company_id"))
        );
    }
}