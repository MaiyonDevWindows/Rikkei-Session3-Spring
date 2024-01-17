package com.ra.model.entity;

import com.ra.model.entity.enums.ActiveStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(nullable = false, unique = true)
    @Length(min = 6, max = 100,
            message = "Username must be at least 6 characters, and must not be more than 100 characters.")
    @Pattern(regexp = "^[^\\W_]+$")
    private String username;
    @Email(message = "Email is not valid, please try again.")
    private String email;
    @Column(nullable = false)
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private ActiveStatus userStatus;
    @Column(nullable = false)
    private String password;
    private String avatar;
    @Column(unique = true)
    private String phone;
    @Column(nullable = true)
    private String address;
    private Date createAt;
    private Date updateAt;
    // User - Order: 1 - N.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull(message = "User id must not be null.")
    @Column(nullable = false)
    List<Order> orders = new ArrayList<>();
    // User - Address: 1 - N.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Address> addresses = new ArrayList<>();
    // User - Product => ShoppingCart: N - N.
    @OneToMany(mappedBy = "user")
    List<ShoppingCart> shoppingCarts = new ArrayList<>();
    // User - Product => WishList: N - N.
    @OneToMany(mappedBy = "user")
    List<WishList> wishLists = new ArrayList<>();
}