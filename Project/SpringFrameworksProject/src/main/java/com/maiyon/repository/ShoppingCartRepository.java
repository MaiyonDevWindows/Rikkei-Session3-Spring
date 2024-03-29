package com.maiyon.repository;

import com.maiyon.model.entity.ShoppingCart;
import com.maiyon.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Page<ShoppingCart> findAllByUser(User user, Pageable pageable);

    ShoppingCart findByShoppingCartIdAndUser(Integer id, User user);

    void deleteByUser(User user);

    List<ShoppingCart> findAllByUser(User user);
}
