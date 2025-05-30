package com.myrecipes.backend.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeIngredientDTO;
import com.myrecipes.backend.entity.Ingredient;
import com.myrecipes.backend.entity.RecipeIngredient;
import com.myrecipes.backend.repository.IngredientRepository;
import com.myrecipes.backend.repository.RecipeIngredientRepository;
import com.myrecipes.backend.repository.RecipeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository,
            RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<RecipeIngredientDTO> getByRecipeId(Long recipeId) {
        return recipeIngredientRepository.findByRecipeId(recipeId).stream()
                .map(RecipeIngredientDTO::new)
                .toList();
    }

    @Transactional
    public RecipeIngredientDTO save(RecipeIngredientDTO ri) {
        RecipeIngredient riSaved = new RecipeIngredient();
        riSaved.setRecipe(recipeRepository.findById(ri.getRecipeId()).get());
        riSaved.setIngredient(ingredientRepository.findById(ri.getIngredientId()).get());
        riSaved.setQuantity(ri.getQuantity());
        riSaved.setUnit(ri.getUnit());

        return new RecipeIngredientDTO(recipeIngredientRepository.save(riSaved));
    }

    @Transactional
    public void delete(Long id) {
        recipeIngredientRepository.deleteById(id);
    }

    public List<RecipeIngredientDTO> getByUserId(Long userId) {
        return recipeIngredientRepository.findByRecipe_UserId(userId).stream()
                .map(RecipeIngredientDTO::new)
                .toList();
    }

    @Transactional
    public RecipeIngredientDTO update(RecipeIngredientDTO ri) {
        Ingredient ingredient = ingredientRepository.findByName(ri.getIngredientName())
                .orElseGet(() -> {
                    Ingredient newIngredient = new Ingredient();
                    newIngredient.setName(ri.getIngredientName());
                    newIngredient.setDescription(null);
                    newIngredient.setCreatedAt(OffsetDateTime.now());
                    return ingredientRepository.save(newIngredient);
                });

        RecipeIngredient riToUpdate = recipeIngredientRepository.findById(ri.getId())
                .orElseThrow(() -> new EntityNotFoundException("RecipeIngredient no encontrado con id: " + ri.getId()));

        riToUpdate.setIngredient(ingredient);
        riToUpdate.setQuantity(ri.getQuantity());
        riToUpdate.setUnit(ri.getUnit());

        RecipeIngredient saved = recipeIngredientRepository.save(riToUpdate);
        return new RecipeIngredientDTO(saved);
    }

}
