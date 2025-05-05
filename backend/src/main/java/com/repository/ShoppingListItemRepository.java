package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ShoppingListItem;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {
}
