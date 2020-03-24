package com.ecommerce.sprintboot.controller.impl;

import com.ecommerce.sprintboot.controller.IController;
import com.ecommerce.sprintboot.entity.Article;
import com.ecommerce.sprintboot.entity.User;
import com.ecommerce.sprintboot.service.IService;
import com.ecommerce.sprintboot.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArticleController extends IController<Article> {

    @Autowired
    private ArticleServiceImpl articleService;

    @Override
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllEntities() {
        List<Article> articles = articleService.findAll();

        if(articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @Override
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getEntityById(@PathVariable("id") Long id) {
        Optional<Article> articleData = articleService.findById(id);

        if (articleData.isPresent()) {
            return new ResponseEntity<>(articleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    @PostMapping("/articles")
    public ResponseEntity<Article> createEntity(@RequestBody Article entity) {
        try{
            Article article  = new Article( entity );
            article = articleService.save( article);
            return new ResponseEntity<>(article, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateEntity(@PathVariable("id") Long id,@RequestBody Article entity) {
        Optional<Article> articleData = articleService.findById(id);
        if( articleData.isPresent()){
            Article _article = articleData.get();
            _article.setArticle( entity);
            return new ResponseEntity( articleService.save(_article), HttpStatus.OK);
        } else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/articles/{id]")
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable("id") Long id) {
        try{
            articleService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch( Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
