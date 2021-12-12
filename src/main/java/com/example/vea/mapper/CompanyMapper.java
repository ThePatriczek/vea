package com.example.vea.mapper;

import com.example.vea.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Company(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}