package com.ecommerce.sprintboot.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Table( name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name ="user_id")
    private Long id;
    @Column( name = "active")
    @NotEmpty
    private int active;
    @Column(nullable=false, name = "last_name")
    @NotEmpty
    private String name;
    @Column(nullable=false, name = "first_name")
    @NotEmpty
    private String f_name;
    @Column( nullable = false, unique = true)
    @NotEmpty
    @Email( message = "{erros.invalid_email}")
    private String email;
    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id")})
    @ToString.Exclude
    private Set<Role> roles;

    public User() {
    }

    public User(User user) {
        System.out.println("Constructor " +  user.getEmail());
        System.out.println("Constructor " +  user.getRoles());
        this.active = user.getActive();
        this.email = user.getEmail();
        this.name = user.getName();
        this.password = user.getPassword();
        this.id = user.getId();
        this.roles = user.getRoles();
    }

    public void setUser( User user){
        this.active = user.getActive();
        this.email = user.getEmail();
        this.name = user.getName();
        this.password = user.getPassword();
        this.id = user.getId();
        this.roles = user.getRoles();
    }
}
