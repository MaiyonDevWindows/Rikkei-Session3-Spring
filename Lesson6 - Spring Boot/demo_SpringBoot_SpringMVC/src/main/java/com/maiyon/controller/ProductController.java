package com.maiyon.controller;

import com.maiyon.model.entity.Category;
import com.maiyon.model.entity.Product;
import com.maiyon.service.CategoryService;
import com.maiyon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public String product(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product/index";
    }
    @GetMapping("/add-product")
    public String save(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/add";
    }
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product";
    }
}
