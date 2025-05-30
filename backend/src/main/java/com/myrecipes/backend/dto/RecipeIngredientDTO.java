package com.myrecipes.backend.dto;

import com.myrecipes.backend.entity.RecipeIngredient;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RecipeIngredientDTO {
    private Long id;
    private String ingredientName;
    private Long ingredientId;
    private Long recipeId;
    private Double quantity;
    private String unit;
    private Long userId;

    public RecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        this.id = recipeIngredient.getId();
        this.ingredientName = recipeIngredient.getIngredient().getName();
        this.ingredientId = recipeIngredient.getIngredient().getId();
        this.recipeId = recipeIngredient.getRecipe().getId();
        this.quantity = recipeIngredient.getQuantity();
        this.unit = recipeIngredient.getUnit();
        this.userId = recipeIngredient.getRecipe().getUser().getId();
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
