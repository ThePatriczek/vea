package com.example.vea.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEVELOPER")
public class Developer extends Employee {

    @Column(name = "language")
    private String language;

    public Developer() {
        super();
    }

    public Developer(int id, String name, String language, Company company) {
        super(id, name, company);
        this.language = language;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
