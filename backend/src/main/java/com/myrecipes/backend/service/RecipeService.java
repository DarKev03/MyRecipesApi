package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeDTO;
import com.myrecipes.backend.entity.Recipe;
import com.myrecipes.backend.repository.RecipeRepository;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(RecipeDTO::new)
                .toList();
    }

    public Optional<RecipeDTO> getRecipeById(Long id) {
        return recipeRepository.findById(id).map(RecipeDTO::new);
    }

    public List<RecipeDTO> getRecipesByUserId(Long userId) {
        return recipeRepository.findByUserId(userId).stream()
                .map(RecipeDTO::new)
                .toList();
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe updateRecipe(Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(updatedRecipe.getId())
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setCategory(updatedRecipe.getCategory());
        existingRecipe.setPrepTime(updatedRecipe.getPrepTime());
        existingRecipe.setImageUrl(updatedRecipe.getImageUrl());
        existingRecipe.setIsFavorite(updatedRecipe.getIsFavorite());
        return recipeRepository.save(existingRecipe);
    }
}
