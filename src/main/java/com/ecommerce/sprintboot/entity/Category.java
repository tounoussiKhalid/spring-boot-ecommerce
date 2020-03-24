package com.ecommerce.sprintboot.entity;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table( name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="refcat")
    private Long id;

    @NotEmpty
    @Column(name = "cat")
    private String category;

    public Category(){
    }

    public Category( Category cat){
        this.category = cat.getCategory();
    }

    public void setCategory( Category cat){
        this.category = cat.getCategory();
    }
}