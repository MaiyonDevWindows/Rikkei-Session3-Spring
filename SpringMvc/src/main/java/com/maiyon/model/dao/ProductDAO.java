package com.maiyon.model.dao;

import com.maiyon.model.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductDAO implements DAO<Product>{
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean saveOrUpdate(Product product) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
