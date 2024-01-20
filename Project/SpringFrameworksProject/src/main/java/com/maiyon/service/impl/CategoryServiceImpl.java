package com.maiyon.service.impl;

import com.maiyon.model.dto.response.CategoryResponse;
import com.maiyon.model.entity.Category;
import com.maiyon.repository.CategoryRepository;
import com.maiyon.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    CategoryServiceImpl(){
        this.mapper = new ModelMapper();
    }
    private void configureModelMapper(){
        mapper.addMappings(new PropertyMap<Category, CategoryResponse>() {
            @Override
            protected void configure() {
                map().setId(source.getCategoryId());
                map().setCategoryName(source.getCategoryName());
                map().setDescription(source.getDescription());
            }
        });
    }
    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        return categories.stream().map(
                category -> mapper.map(
                        category, CategoryResponse.class)
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryResponse> findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return Optional.ofNullable(mapper.map(categoryOptional, CategoryResponse.class));
    }
}
