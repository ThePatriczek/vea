package com.example.vea.model;

import javax.persistence.*;

@Entity
public class Project {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Project(int id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Project() {

    }

    public Project(int project_id) {
        this.id = project_id;
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
