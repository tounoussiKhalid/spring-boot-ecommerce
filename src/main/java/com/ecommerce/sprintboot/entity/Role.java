package com.ecommerce.sprintboot.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name ="role_id")
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String description;

}
