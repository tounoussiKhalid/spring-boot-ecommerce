package com.ecommerce.sprintboot.service;

import java.util.List;
import java.util.Optional;

public interface IService<E> {

    List<E> findAll();

    E save(E entite);

    Optional<E> findById(long id);

    void delete( long id );
}
