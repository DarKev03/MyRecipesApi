package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.ShoppingListItemDTO;
import com.myrecipes.backend.entity.ShoppingListItem;
import com.myrecipes.backend.repository.ShoppingListItemRepository;
import com.myrecipes.backend.repository.ShoppingListRepository;
import com.myrecipes.backend.repository.IngredientRepository;

import jakarta.transaction.Transactional;

@Service
public class ShoppingListItemService {
    private final ShoppingListItemRepository shoppingListItemRepository;
    private final IngredientRepository ingredientRepository;
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListItemService(ShoppingListItemRepository shoppingListItemRepository,
            IngredientRepository ingredientRepository, ShoppingListRepository shoppingListRepository) {
        this.shoppingListItemRepository = shoppingListItemRepository;
        this.ingredientRepository = ingredientRepository;
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingListItemDTO> getAll() {
        return shoppingListItemRepository.findAll().stream()
                .map(ShoppingListItemDTO::new)
                .toList();
    }

    @Transactional
    public ShoppingListItemDTO save(ShoppingListItemDTO item) {
        ShoppingListItem shoppingListItem = new ShoppingListItem();
        shoppingListItem.setIngredient(ingredientRepository.findById(item.getIngredientId())
                .orElseThrow(
                        () -> new IllegalArgumentException("Ingredient not found with id: " + item.getIngredientId())));
        shoppingListItem.setQuantity(item.getQuantity());
        shoppingListItem.setUnit(item.getUnit());
        shoppingListItem.setShoppingList(shoppingListRepository.findById(item.getShoppingListId())
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Shopping List not found with id: " + item.getShoppingListId())));
        shoppingListItem.setIngredient(ingredientRepository.findById(item.getIngredientId())
                .orElseThrow(
                        () -> new IllegalArgumentException("Ingredient not found with id: " + item.getIngredientId())));
        ShoppingListItem savedItem = shoppingListItemRepository.save(shoppingListItem);
        return new ShoppingListItemDTO(savedItem);
    }

    @Transactional
    public void delete(Long id) {
        shoppingListItemRepository.deleteById(id);
    }

    public List<ShoppingListItemDTO> getByShoppingListId(Long shoppingListId) {
        return shoppingListItemRepository.findByShoppingList_Id(shoppingListId).stream()
                .map(ShoppingListItemDTO::new)
                .toList();
    }
}
