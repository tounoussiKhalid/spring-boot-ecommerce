package com.ecommerce.sprintboot.service.impl;

import com.ecommerce.sprintboot.entity.Category;
import com.ecommerce.sprintboot.repository.CategoryRepository;
import com.ecommerce.sprintboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements IService<Category> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category entite) {
        return categoryRepository.save( entite);
    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
