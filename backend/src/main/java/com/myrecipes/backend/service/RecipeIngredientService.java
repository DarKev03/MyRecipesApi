package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeIngredientDTO;
import com.myrecipes.backend.entity.RecipeIngredient;
import com.myrecipes.backend.repository.RecipeIngredientRepository;

@Service
public class RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<RecipeIngredientDTO> getByRecipeId(Long recipeId) {
        return recipeIngredientRepository.findByRecipeId(recipeId).stream()
            .map(RecipeIngredientDTO::new)
            .toList();
    }
    

    public RecipeIngredientDTO save(RecipeIngredient ri) {

        RecipeIngredient riSaved = recipeIngredientRepository.save(ri);
        return new RecipeIngredientDTO(riSaved);
    }

    public void delete(Long id) {
        recipeIngredientRepository.deleteById(id);
    }

    public List<RecipeIngredientDTO> getByUserId(Long userId) {
        return recipeIngredientRepository.findByUserId(userId).stream()
            .map(RecipeIngredientDTO::new)
            .toList();
    }
}
