package com.ecommerce.sprintboot.repository;

import com.ecommerce.sprintboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);
}
