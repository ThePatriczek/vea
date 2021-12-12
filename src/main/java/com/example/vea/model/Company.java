package com.example.vea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Column(name = "id")
    @Id
    Integer id;

    @Column(name = "name")
    String name;

    public Company(int company_id) {
        this.id = company_id;
    }

    public Company() {

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
