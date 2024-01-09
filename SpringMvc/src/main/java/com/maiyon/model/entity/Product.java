package com.maiyon.model.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String productName;
    @Column(name = "price")
    private Float productPrice;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "email")
    private String email;

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String productName, Float productPrice, Integer categoryId, String email) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
