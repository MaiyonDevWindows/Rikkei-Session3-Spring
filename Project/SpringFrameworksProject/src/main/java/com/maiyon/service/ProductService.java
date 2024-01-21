package com.maiyon.service;

import com.maiyon.model.dto.request.ProductRequest;
import com.maiyon.model.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<ProductResponse> findAll(Pageable pageable);
    Optional<ProductResponse> findById(Long id);
    Page<ProductResponse> findByCategoryId(Pageable pageable, Long categoryId);
    Page<ProductResponse> searchByNameOrDescription(Pageable pageable, String keyword);
    Optional<ProductResponse> save(ProductRequest productRequest);
    Boolean delete(Long id);
}
