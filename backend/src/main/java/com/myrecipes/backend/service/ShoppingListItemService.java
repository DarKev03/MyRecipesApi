package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.ShoppingListItemDTO;
import com.myrecipes.backend.entity.ShoppingListItem;
import com.myrecipes.backend.repository.ShoppingListItemRepository;

@Service
public class ShoppingListItemService {
    private final ShoppingListItemRepository shoppingListItemRepository;

    public ShoppingListItemService(ShoppingListItemRepository shoppingListItemRepository) {
        this.shoppingListItemRepository = shoppingListItemRepository;
    }

    public List<ShoppingListItemDTO> getAll() {
        return shoppingListItemRepository.findAll().stream()
                .map(ShoppingListItemDTO::new)
                .toList();
    }

    public ShoppingListItemDTO save(ShoppingListItem item) {
        ShoppingListItem shoppingListItemSaved = shoppingListItemRepository.save(item);
        return new ShoppingListItemDTO(shoppingListItemSaved);
    }

    public void delete(Long id) {
        shoppingListItemRepository.deleteById(id);
    }
}
