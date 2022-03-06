package com.women.spring.service;

import com.women.spring.model.Formation;

import java.util.List;

public interface ICrudRepository <T>{
    T save(T t);
    T update( T t );
    T findById( Long id);
    void delete ( Long id);
    List<T> findAll(); 

}
