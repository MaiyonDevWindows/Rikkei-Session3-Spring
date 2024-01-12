package com.maiyon.services;

import com.maiyon.models.entities.Product;
import com.maiyon.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> searchProductsByCategoryId(Long categoryId) {
        return productRepository.searchProductsByCategoryId(categoryId);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
