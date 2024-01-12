package com.maiyon.models.repositories;

import com.maiyon.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> searchProductsByCategoryId(Long categoryId);
}