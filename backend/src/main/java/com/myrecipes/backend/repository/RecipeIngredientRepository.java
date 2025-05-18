package com.myrecipes.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    List<RecipeIngredient> findByRecipeId(Long recipeId);
}
