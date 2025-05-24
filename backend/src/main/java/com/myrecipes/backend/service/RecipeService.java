package com.myrecipes.backend.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeDTO;
import com.myrecipes.backend.entity.Recipe;
import com.myrecipes.backend.entity.User;
import com.myrecipes.backend.repository.RecipeRepository;
import com.myrecipes.backend.repository.UserRepository;

@Service
public class RecipeService {
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public RecipeDTO saveRecipe(RecipeDTO recipeDto) {
        User user = userRepository.findById(recipeDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Recipe recipe = new Recipe();
        recipe.setUser(user);
        recipe.setTitle(recipeDto.getTitle());
        recipe.setCategory(recipeDto.getCategory());
        recipe.setImageUrl(recipeDto.getImageUrl());
        recipe.setIsFavorite(recipeDto.getIsFavorite());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setCreatedAt(OffsetDateTime.now());        

        return new RecipeDTO(recipeRepository.save(recipe));
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public RecipeDTO updateRecipe(Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(updatedRecipe.getId())
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setCategory(updatedRecipe.getCategory());
        existingRecipe.setPrepTime(updatedRecipe.getPrepTime());
        existingRecipe.setImageUrl(updatedRecipe.getImageUrl());
        existingRecipe.setIsFavorite(updatedRecipe.getIsFavorite());
        Recipe newUpdatedRecipe = recipeRepository.save(existingRecipe);
        return new RecipeDTO(newUpdatedRecipe);
    }
}
