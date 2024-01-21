package com.maiyon.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String sku;
    @Column(nullable = false, unique = true)
    @NotNull(message = "Product name must not be null.")
    @NotEmpty(message = "Product name must not be empty.")
    private String productName;
    private String description;
    private Double unitPrice;
    @Min(value = 0, message = "Stock quantity must be equals or greater than zero.")
    private int stockQuantity = 0;
    private String image;
    private Date createdAt;
    private Date updatedAt;
    // Category - Product: 1 - N.
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    // Product - User => ShoppingCart: N - N.
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();
    // Product - User => WishList: N - N.
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<WishList> wishLists = new ArrayList<>();
}