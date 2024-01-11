package com.maiyon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Float productPrice;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryId;
}
