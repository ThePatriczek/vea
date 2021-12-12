package com.example.vea.model;

import javax.persistence.*;

@MappedSuperclass
public class Employee {
    @Column(name = "id")
    @Id
    Integer id;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Employee(int id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Employee() {

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
