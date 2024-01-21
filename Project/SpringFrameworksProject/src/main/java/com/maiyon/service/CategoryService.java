package com.maiyon.service;

import com.maiyon.model.dto.response.CategoryResponse;
import com.maiyon.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Page<CategoryResponse> findAll(Pageable pageable);

    Optional<CategoryResponse> findById(Long id);
    Optional<CategoryResponse> save(Category category);
    Boolean delete(Long id);
}