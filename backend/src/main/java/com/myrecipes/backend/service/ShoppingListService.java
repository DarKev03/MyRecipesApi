package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.ShoppingListDTO;
import com.myrecipes.backend.entity.ShoppingList;
import com.myrecipes.backend.repository.ShoppingListRepository;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingListDTO> getAll() {
        return shoppingListRepository.findAll().stream()
                .map(ShoppingListDTO::new)
                .toList();
    }

    public Optional<ShoppingListDTO> getById(Long id) {
        return shoppingListRepository.findById(id).map(ShoppingListDTO::new);
    }

    public ShoppingList save(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public void delete(Long id) {
        shoppingListRepository.deleteById(id);
    }
}
