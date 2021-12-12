package com.example.vea.repository;

import com.example.vea.mapper.EmployeeMapper;
import com.example.vea.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeRepositoryJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeMapper());
    }

    public Employee findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE id = ?", new Object[]{id}, new EmployeeMapper());
    }

    public void save(Employee employee) {
        if (employee.getId() > 0) {
            jdbcTemplate.update("UPDATE EMPLOYEE SET name = ?, company_id = ?, WHERE id = ?",
                    employee.getName(), employee.getCompany().getId(), employee.getId());
        } else {
            jdbcTemplate.update("INSERT INTO EMPLOYEE(name, company_id) VALUES(?, ?, ?)",
                    employee.getName(), employee.getCompany().getId());
        }

    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE id = ?", id);
    }
}