package com.maiyon.controllers;

import com.maiyon.models.entities.Category;
import com.maiyon.models.entities.Product;
import com.maiyon.services.CategoryService;
import com.maiyon.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Value("${static.path}")
    private String staticPath;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String product(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        Product product = productService.findById(id);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product/detail";
    }
    @GetMapping("/{category_id}")
    public String searchProductsByCategoryId(Model model, @PathVariable("category_id") Long categoryId){
        List<Product> products = productService.searchProductsByCategoryId(categoryId);
        model.addAttribute("category_id", categoryId);
        model.addAttribute("products", products);
        return "product/index";
    }
    @GetMapping("/add-product/")
    public String create(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/add";
    }
    @GetMapping("/add-product/{category-id}")
    public String create(Model model, @PathVariable("category-id") Long categoryId){
        List<Category> categories = categoryService.getAll();
        Product product = new Product();
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product/add";
    }
    @GetMapping("/edit-product/{id}")
    public String update(Model model, @PathVariable("id") Long productId){
        Product product = productService.findById(productId);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product/edit";
    }
    @PostMapping("/save-product")
    public String save(@ModelAttribute("product") Product product,
                             @RequestParam("product-image") MultipartFile file){
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(staticPath + fileName));
            product.setImage(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable("id") Long productId){
        productService.delete(productId);
        return "redirect:/product";
    }
}
