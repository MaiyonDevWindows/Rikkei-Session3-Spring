package com.maiyon.controller.admin;

import com.maiyon.model.dto.response.CategoryResponse;
import com.maiyon.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/admin/categories")
public class ACategoryController {
    @Autowired
    private CategoryService categoryService;
    private final Logger logger =
            LoggerFactory.getLogger(ACategoryController.class);
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        List<CategoryResponse> categoryResponses = categoryService.findAll();
        logger.info("Admin - Get all categories - successful.");
        return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long categoryId){
        Optional<CategoryResponse> categoryResponse = categoryService.findById(categoryId);
        if(categoryResponse.isPresent()){
            logger.info("Admin - Get category by id: {}  - successful.", categoryId);
            return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
        }
        logger.error("Admin - Get category by id: {} - failure.", categoryId);
        return new ResponseEntity<>("Category is not exist", HttpStatus.NOT_FOUND);
    }
}
