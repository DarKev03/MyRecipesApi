package com.myrecipes.backend.dto;

import com.myrecipes.backend.entity.ShoppingListItem;

public class ShoppingListItemDTO {
    private String ingredientName;
    private Double quantity;
    private String unit;

    public ShoppingListItemDTO(ShoppingListItem item) {
        this.ingredientName = item.getIngredient().getName();
        this.quantity = item.getQuantity();
        this.unit = item.getUnit();
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
