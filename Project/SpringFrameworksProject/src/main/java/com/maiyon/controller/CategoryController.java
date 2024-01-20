package com.maiyon.controller;

import com.maiyon.model.dto.response.CategoryResponse;
import com.maiyon.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private final Logger logger =
            LoggerFactory.getLogger(CategoryController.class);
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        List<CategoryResponse> categoryResponses = categoryService.findAll();
        logger.info("Any - Get all categories - successful.");
        return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
    }
}
