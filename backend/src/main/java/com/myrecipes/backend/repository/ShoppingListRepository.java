package com.myrecipes.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    List<ShoppingList> findByUserId(Long userId);    
    ShoppingList findByItems_Id(Long itemId);
}
