package com.myrecipes.backend.dto;

import com.myrecipes.backend.entity.ShoppingListItem;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShoppingListItemDTO {
    private String ingredientName;
    private Long ingredientId;
    private Double quantity;
    private Long id;
    private String unit;
    private Long shoppingListId;

    public ShoppingListItemDTO(ShoppingListItem item) {
        this.id = item.getId();
        this.ingredientName = item.getIngredient().getName();
        this.ingredientId = item.getIngredient().getId();
        this.quantity = item.getQuantity();
        this.unit = item.getUnit();
        this.shoppingListId = item.getShoppingList().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Long shoppingListId) {
        this.shoppingListId = shoppingListId;
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

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

}
