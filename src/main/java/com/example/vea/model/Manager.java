package com.example.vea.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MANAGER")
public class Manager extends Employee {
}
