package com.ecommerce.sprintboot.repository;

import com.ecommerce.sprintboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
