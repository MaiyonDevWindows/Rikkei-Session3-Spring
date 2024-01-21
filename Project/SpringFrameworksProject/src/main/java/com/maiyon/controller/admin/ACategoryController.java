package com.maiyon.controller.admin;

import com.maiyon.model.dto.response.CategoryResponse;
import com.maiyon.model.entity.Category;
import com.maiyon.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/v1/admin/categories")
public class ACategoryController {
    @Autowired
    private CategoryService categoryService;
    private final Logger logger =
            LoggerFactory.getLogger(ACategoryController.class);
    @GetMapping
    public ResponseEntity<?> getAllCategories(
            @RequestParam(defaultValue = "5",name = "limit") Integer limit,
            @RequestParam(defaultValue = "0",name = "page") Integer page,
            @RequestParam(defaultValue = "categoryName",name = "sort") String sortBy,
            @RequestParam(defaultValue = "asc", name = "direction") String orderBy){
        Pageable pageable = PageRequest.of(page, limit, Sort.by(orderBy, sortBy));
        try{
            Page<CategoryResponse> categoryResponses = categoryService.findAll(pageable);
            if(!categoryResponses.isEmpty()){
                logger.info("Admin - Get categories at page {} - successful.", page);
                return new ResponseEntity<>(categoryResponses.getContent(), HttpStatus.OK);
            }
            return new ResponseEntity<>("Categories page is empty.", HttpStatus.UNAUTHORIZED);
        } catch (Exception e){
            logger.error("Admin - Get categories at page {} - failure", page);
            return new ResponseEntity<>("Categories page out of range.", HttpStatus.UNAUTHORIZED);
        }
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
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        Optional<CategoryResponse> categoryResponse = categoryService.save(category);
        if (categoryResponse.isPresent()){
            logger.info("Admin - Create category - successful.");
            return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
        }
        logger.error("Admin - Create category - failure.");
        return new ResponseEntity<>("Can not create Category", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<?> updateCategory(
            @PathVariable("categoryId") Long categoryId,
            @RequestBody Category category){
        category.setCategoryId(categoryId);
        Optional<CategoryResponse> categoryResponse = categoryService.save(category);
        if(categoryResponse.isPresent()){
            logger.info("Admin - Update Category - successful.");
            return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
        }
        logger.error("Admin - Update Category - failure.");
        return new ResponseEntity<>("Can not update Category", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Long categoryId){
        if(categoryService.delete(categoryId)){
            logger.info("Admin - Delete Category - successful.");
            return new ResponseEntity<>("Delete success.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failure.", HttpStatus.NOT_FOUND);
    }
}
