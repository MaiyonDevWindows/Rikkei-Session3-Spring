package com.maiyon.service;

import com.maiyon.model.dao.CategoryDAO;
import com.maiyon.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }

    @Override
    public Boolean saveOrUpdate(Category category) {
        return categoryDAO.saveOrUpdate(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.delete(id);
    }
}
