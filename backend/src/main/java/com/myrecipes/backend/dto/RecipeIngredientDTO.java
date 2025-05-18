package com.myrecipes.backend.dto;
import com.myrecipes.backend.entity.RecipeIngredient;

public class RecipeIngredientDTO {
    private String ingredientName;
    private Double quantity;
    private String unit;

    public RecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        this.ingredientName = recipeIngredient.getIngredient().getName();
        this.quantity = recipeIngredient.getQuantity();
        this.unit = recipeIngredient.getUnit();
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
}
