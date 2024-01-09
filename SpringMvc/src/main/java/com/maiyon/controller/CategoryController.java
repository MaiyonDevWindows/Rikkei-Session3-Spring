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
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category";
    }
}
