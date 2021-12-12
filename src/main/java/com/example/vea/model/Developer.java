package com.example.vea.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DEVELOPER")
public class Developer extends Employee {

    @Column(name = "language")
    private String language;

    public Developer() {
        super();
    }

    public Developer(int id, String name, String language, Company company, Project project) {
        super(id, name, company, project);
        this.language = language;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
