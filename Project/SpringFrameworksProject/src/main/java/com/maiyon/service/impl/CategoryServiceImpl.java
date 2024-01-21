package com.maiyon.service.impl;

import com.maiyon.model.dto.response.CategoryResponse;
import com.maiyon.model.entity.Category;
import com.maiyon.repository.CategoryRepository;
import com.maiyon.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Page<CategoryResponse> findAll(Pageable pageable){
        List<Category> categories = categoryRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        List<CategoryResponse> categoryResponses = categories.stream().map(
                category -> mapper.map(category, CategoryResponse.class)
        ).toList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), categoryResponses.size());
        return PageableExecutionUtils.getPage(categoryResponses.subList(start, end), pageable, categoryResponses::size);
    }

    public static <T> Pageable createPageable(List<T> content, Pageable sourcePageable) {
        int start = (int) sourcePageable.getOffset();
        int end = Math.min((start + sourcePageable.getPageSize()), content.size());

        return (Pageable) new PageImpl<>(content.subList(start, end), sourcePageable, content.size());
    }

    @Override
    public Optional<CategoryResponse> findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return Optional.ofNullable(mapper.map(categoryOptional, CategoryResponse.class));
    }

    @Override
    public Optional<CategoryResponse> save(Category category) {
        Category updateCategory = categoryRepository.save(category);
        return Optional.ofNullable(mapper.map(updateCategory, CategoryResponse.class));
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty())  return false;
        categoryRepository.deleteById(id);
        return true;
    }
}
