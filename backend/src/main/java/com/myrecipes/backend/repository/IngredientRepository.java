package com.myrecipes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
