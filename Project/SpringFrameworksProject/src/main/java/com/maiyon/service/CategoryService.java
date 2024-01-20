package com.maiyon.service;

import com.maiyon.model.dto.response.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponse> findAll();
}