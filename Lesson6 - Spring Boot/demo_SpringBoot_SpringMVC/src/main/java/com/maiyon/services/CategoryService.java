package com.maiyon.services;

import com.maiyon.models.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    Category findById(Long id);
    void delete(Long id);
}
