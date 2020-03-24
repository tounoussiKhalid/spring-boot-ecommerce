package com.ecommerce.sprintboot.repository;

import com.ecommerce.sprintboot.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
