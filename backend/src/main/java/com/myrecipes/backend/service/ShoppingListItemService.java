package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.entity.ShoppingListItem;
import com.myrecipes.backend.repository.ShoppingListItemRepository;

@Service
public class ShoppingListItemService {
    private final ShoppingListItemRepository shoppingListItemRepository;

    public ShoppingListItemService(ShoppingListItemRepository shoppingListItemRepository) {
        this.shoppingListItemRepository = shoppingListItemRepository;
    }

    public List<ShoppingListItem> getAll() {
        return shoppingListItemRepository.findAll();
    }

    public ShoppingListItem save(ShoppingListItem item) {
        return shoppingListItemRepository.save(item);
    }

    public void delete(Long id) {
        shoppingListItemRepository.deleteById(id);
    }
}
