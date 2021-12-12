package com.example.vea.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Column(name = "id")
    @Id
    Integer id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    List<Developer> developers;

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
