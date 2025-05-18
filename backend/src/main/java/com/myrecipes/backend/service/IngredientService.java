package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.IngredientDTO;
import com.myrecipes.backend.entity.Ingredient;
import com.myrecipes.backend.repository.IngredientRepository;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(IngredientDTO::new)
                .toList();
    }

    public Optional<IngredientDTO> getIngredientById(Long id) {
        return ingredientRepository.findById(id).map(IngredientDTO::new);
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
