package com.maiyon.controller;

import com.maiyon.model.entity.Category;
import com.maiyon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
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

    // Query Params.
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        categoryService.delete(id);
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
