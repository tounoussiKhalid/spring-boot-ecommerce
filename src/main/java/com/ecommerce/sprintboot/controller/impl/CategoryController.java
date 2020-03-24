package com.ecommerce.sprintboot.controller.impl;

import com.ecommerce.sprintboot.controller.IController;
import com.ecommerce.sprintboot.entity.Category;
import com.ecommerce.sprintboot.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CategoryController extends IController<Category> {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Override
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllEntities() {
        List<Category> categories = categoryService.findAll();

        if(categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getEntityById(@PathVariable("id") Long id) {
        Optional<Category> categoryData = categoryService.findById(id);

        if (categoryData.isPresent()) {
            return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping("/categories")
    public ResponseEntity<Category> createEntity(@RequestBody Category entity) {
        try{
            Category category  = new Category( entity );
            category = categoryService.save( category);
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateEntity(@PathVariable("id") Long id,@RequestBody Category entity) {
        Optional<Category> categoryData = categoryService.findById(id);
        if( categoryData.isPresent()){
            Category _category = categoryData.get();
            _category.setCategory( entity);
            return new ResponseEntity( categoryService.save(_category), HttpStatus.OK);
        } else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/categories/{id]")
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable("id") Long id) {
        try{
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch( Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
