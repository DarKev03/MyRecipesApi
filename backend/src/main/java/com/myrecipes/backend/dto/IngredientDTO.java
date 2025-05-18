package com.myrecipes.backend.dto;

import java.time.OffsetDateTime;

import com.myrecipes.backend.entity.Ingredient;

public class IngredientDTO {
    private Long id;
    private String name;
    private String description;
    private OffsetDateTime createdAt;

    public IngredientDTO(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.description = ingredient.getDescription();
        this.createdAt = ingredient.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
