package com.example.vea.mappers;

import com.example.vea.model.Company;
import com.example.vea.model.Employee;
import com.example.vea.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                new Company(rs.getInt("company_id")),
                new Project(rs.getInt("project_id")));
    }
}