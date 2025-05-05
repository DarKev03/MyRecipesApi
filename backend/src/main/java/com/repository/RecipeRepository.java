package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Custom query to find recipes by user ID
    List<Recipe> findByUserId(Long userId);
}
