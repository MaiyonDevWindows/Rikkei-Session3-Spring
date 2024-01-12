package com.maiyon.models.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Float productPrice;
    private String image;
    private Integer quantity = 0;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
