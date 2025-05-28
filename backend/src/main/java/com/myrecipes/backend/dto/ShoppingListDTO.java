package com.myrecipes.backend.dto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.myrecipes.backend.entity.ShoppingList;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShoppingListDTO {
    private Long id;
    private String name;
    private OffsetDateTime createdAt;
    private Long userId;

    public ShoppingListDTO(ShoppingList list) {
        this.id = list.getId();
        this.userId = list.getUser().getId();
        this.name = list.getName();
        this.createdAt = list.getCreatedAt();
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
