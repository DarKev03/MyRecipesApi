package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.entity.RecipeIngredient;
import com.myrecipes.backend.repository.RecipeIngredientRepository;

@Service
public class RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<RecipeIngredient> getAll() {
        return recipeIngredientRepository.findAll();
    }

    public RecipeIngredient save(RecipeIngredient ri) {
        return recipeIngredientRepository.save(ri);
    }

    public void delete(Long id) {
        recipeIngredientRepository.deleteById(id);
    }
}
