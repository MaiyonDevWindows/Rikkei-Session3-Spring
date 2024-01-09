package com.maiyon.model.dao;

import java.util.List;
import java.util.Optional;

public interface DAO <T>{
    List<T> findAll();
    Optional findById(Integer id);
    Boolean saveOrUpdate(T t);
    void delete(Integer id);
}
