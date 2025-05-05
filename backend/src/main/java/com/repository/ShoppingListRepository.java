package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
