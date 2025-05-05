package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
