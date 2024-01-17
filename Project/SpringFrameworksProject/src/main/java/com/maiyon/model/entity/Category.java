package com.maiyon.model.entity;

import com.maiyon.model.entity.enums.ActiveStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    @Column(nullable = false)
    private String categoryName;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "category_status")
    private ActiveStatus categoryStatus;
    // Category - Product: 1 - N.
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> products = new ArrayList<>();
}