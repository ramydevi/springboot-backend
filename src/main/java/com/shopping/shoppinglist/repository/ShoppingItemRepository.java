package com.shopping.shoppinglist.repository;

import com.shopping.shoppinglist.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
}
