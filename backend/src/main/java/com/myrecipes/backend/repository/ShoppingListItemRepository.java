package com.myrecipes.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.ShoppingListItem;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {  
    List<ShoppingListItem> findByShoppingList_Id(Long shoppingListId);
    List<ShoppingListItem> findByIngredient_Id(Long ingredientId);      
}
