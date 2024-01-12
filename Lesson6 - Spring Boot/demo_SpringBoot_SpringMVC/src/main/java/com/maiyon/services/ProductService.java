package com.maiyon.services;

import com.maiyon.models.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product save(Product product);
    Product findById(Long id);
    List<Product> searchProductsByCategoryId(Long categoryId);
    void delete(Long id);
}
