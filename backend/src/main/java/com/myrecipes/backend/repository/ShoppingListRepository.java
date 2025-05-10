package com.myrecipes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
