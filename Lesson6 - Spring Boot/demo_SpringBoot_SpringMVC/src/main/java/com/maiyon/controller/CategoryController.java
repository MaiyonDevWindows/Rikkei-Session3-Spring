package com.maiyon.controller;

import com.maiyon.model.entity.Category;
import com.maiyon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String category(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }
    @GetMapping("/add-category")
    public String save(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }
}
