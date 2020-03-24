package com.ecommerce.sprintboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

@Data
@Table(name = "articles")

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codearticle")
    private Long id;


    @Column( nullable = false, unique = true)
     private String designation;


     private int prix;

     @Column( name = "stock")
     private int quantite;

     @ManyToOne
     @JoinColumn(name = "categorie", nullable = false)
     private Category category;

     public Article(){
     }

     public Article( Article art){
         this.designation = art.getDesignation();
         this.category = art.getCategory();
         this.prix = art.getPrix();
         this.quantite = art.getQuantite();
     }

     public void setArticle( Article art ){
         this.designation = art.getDesignation();
         this.category = art.getCategory();
         this.prix = art.getPrix();
         this.quantite = art.getQuantite();
     }

}
