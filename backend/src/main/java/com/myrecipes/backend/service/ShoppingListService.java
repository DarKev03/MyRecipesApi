package com.myrecipes.backend.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.ShoppingListDTO;
import com.myrecipes.backend.entity.ShoppingList;
import com.myrecipes.backend.repository.ShoppingListRepository;
import com.myrecipes.backend.repository.UserRepository;
import com.myrecipes.backend.repository.IngredientRepository;

import jakarta.transaction.Transactional;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository, UserRepository userRepository,
            IngredientRepository ingredientRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<ShoppingListDTO> getAll() {
        return shoppingListRepository.findAll().stream()
                .map(ShoppingListDTO::new)
                .toList();
    }

    public Optional<ShoppingListDTO> getById(Long id) {
        return shoppingListRepository.findById(id).map(ShoppingListDTO::new);
    }

    @Transactional
    public ShoppingListDTO save(ShoppingListDTO shoppingList) {
        final ShoppingList shoppingListEntity = new ShoppingList();
        shoppingListEntity.setName(shoppingList.getName());
        shoppingListEntity.setUser(userRepository.findById(shoppingList.getUserId())
                .orElseThrow(
                        () -> new IllegalArgumentException("User not found with id: " + shoppingList.getUserId())));
        shoppingListEntity.setCreatedAt(OffsetDateTime.now());

        return new ShoppingListDTO(shoppingListRepository.save(shoppingListEntity));
    }

    @Transactional
    public void delete(Long id) {
        shoppingListRepository.deleteById(id);
    }

    @Transactional
    public List<ShoppingListDTO> getByUserId(Long userId) {
        return shoppingListRepository.findByUserId(userId)
                .stream()
                .map(ShoppingListDTO::new)
                .toList();
    }

}
