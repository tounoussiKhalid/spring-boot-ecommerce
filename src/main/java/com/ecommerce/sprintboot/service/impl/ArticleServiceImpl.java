package com.ecommerce.sprintboot.service.impl;

import com.ecommerce.sprintboot.entity.Article;
import com.ecommerce.sprintboot.repository.ArticleRepository;
import com.ecommerce.sprintboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements IService<Article> {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article save(Article entite) {
        return articleRepository.save(entite);
    }

    @Override
    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        articleRepository.deleteById(id);
    }
}
