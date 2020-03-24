package com.ecommerce.sprintboot.controller.impl;

import com.ecommerce.sprintboot.controller.IController;
import com.ecommerce.sprintboot.entity.User;
import com.ecommerce.sprintboot.service.IService;
import com.ecommerce.sprintboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController extends IController<User> {

    @Autowired
    private UserServiceImpl iService;

    @GetMapping("/users")
    @Override
    public ResponseEntity<List<User>> getAllEntities() {
       List<User> users = iService.findAll();

       if(users.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    @Override
    public ResponseEntity<User> getEntityById(@PathVariable("id") Long id) {
        System.out.println(id);
        Optional<User> userData = iService.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    @Override
    public ResponseEntity<User> createEntity(@RequestBody User entite) {
        try{
            User _user  = new User( entite );
            _user = iService.save( _user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/users/{id}")
    @Override
    public ResponseEntity<User> updateEntity( @PathVariable("id") Long id, @RequestBody User entity) {
        Optional<User> userData = iService.findById(id);
        if( userData.isPresent()){
            User _user = userData.get();
           _user.setUser( entity);
            return new ResponseEntity( iService.save(_user), HttpStatus.OK);
        } else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id]")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable("id") Long id) {
        try{
            iService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch( Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
