package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.entity.Ingredient;
import com.myrecipes.backend.repository.IngredientRepository;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredientById(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return Optional.empty();
        }
        return ingredientRepository.findById(id);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        Optional<Ingredient> existing = ingredientRepository
                .findAll()
                .stream()
                .filter(i -> i.getName().equalsIgnoreCase(ingredient.getName()))
                .findFirst();

        return existing.orElseGet(() -> ingredientRepository.save(ingredient));
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

}
