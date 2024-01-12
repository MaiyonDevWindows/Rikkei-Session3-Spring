package com.maiyon.controllers;

import com.maiyon.models.entities.Category;
import com.maiyon.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String category(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }
    @GetMapping("/add-category")
    public String create(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }
    @GetMapping("/edit-category/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }
    @PostMapping("/save-category")
    public String save(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
