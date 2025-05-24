package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeIngredientDTO;
import com.myrecipes.backend.entity.RecipeIngredient;
import com.myrecipes.backend.repository.IngredientRepository;
import com.myrecipes.backend.repository.RecipeIngredientRepository;
import com.myrecipes.backend.repository.RecipeRepository;

@Service
public class RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository,
            RecipeRepository recipeRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = null;
    }

    public List<RecipeIngredientDTO> getByRecipeId(Long recipeId) {
        return recipeIngredientRepository.findByRecipeId(recipeId).stream()
                .map(RecipeIngredientDTO::new)
                .toList();
    }

    public RecipeIngredientDTO save(RecipeIngredientDTO ri) {
        RecipeIngredient riSaved = new RecipeIngredient();
        riSaved.setRecipe(recipeRepository.findById(ri.getRecipeId()).get());
        riSaved.setIngredient(ingredientRepository.findById(ri.getIngredientId()).get());
        riSaved.setQuantity(ri.getQuantity());
        riSaved.setUnit(ri.getUnit());
                

        return new RecipeIngredientDTO(recipeIngredientRepository.save(riSaved));
    }

    public void delete(Long id) {
        recipeIngredientRepository.deleteById(id);
    }

    public List<RecipeIngredientDTO> getByUserId(Long userId) {
        return recipeIngredientRepository.findByRecipe_UserId(userId).stream()
                .map(RecipeIngredientDTO::new)
                .toList();
    }
}
