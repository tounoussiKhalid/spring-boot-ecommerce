package com.ecommerce.sprintboot.controller;

import com.ecommerce.sprintboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


public abstract class IController<E> {

    public abstract ResponseEntity<List<E>> getAllEntities();

    public abstract ResponseEntity<E> getEntityById(@PathVariable("id") Long id);

    public abstract ResponseEntity<E> createEntity( @RequestBody E entity);

    public abstract ResponseEntity<E> updateEntity( @PathVariable("id") Long id, @RequestBody E entity);

    public abstract ResponseEntity<HttpStatus> deleteEntity(@PathVariable("id") Long id);

}
