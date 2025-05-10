package com.myrecipes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.ShoppingListItem;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {
}
