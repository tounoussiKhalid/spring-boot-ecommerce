package com.ecommerce.sprintboot.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String role;

    public Employee(){}

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}