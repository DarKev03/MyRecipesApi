package com.myrecipes.backend.dto;

import java.time.OffsetDateTime;

import com.myrecipes.backend.entity.Recipe;

public class RecipeDTO {
    private Long id;
    private String title;
    private String category;
    private Integer prepTime;
    private String imageUrl;
    private Boolean isFavorite;
    private OffsetDateTime createdAt;

    public RecipeDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.category = recipe.getCategory();
        this.prepTime = recipe.getPrepTime();
        this.imageUrl = recipe.getImageUrl();
        this.isFavorite = recipe.getIsFavorite();
        this.createdAt = recipe.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String description) {
        this.category = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
