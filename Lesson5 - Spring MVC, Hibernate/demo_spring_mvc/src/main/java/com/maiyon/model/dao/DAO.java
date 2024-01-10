package com.maiyon.model.dao;

import com.maiyon.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface DAO <T>{
    List<T> findAll();
    T findById(Integer id);
    Boolean saveOrUpdate(T t);
    void delete(Integer id);
}
