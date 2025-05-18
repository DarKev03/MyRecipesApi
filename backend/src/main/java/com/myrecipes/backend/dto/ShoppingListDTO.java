package com.myrecipes.backend.dto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.myrecipes.backend.entity.ShoppingList;

public class ShoppingListDTO {
    private Long id;
    private String name;
    private OffsetDateTime createdAt;
    private List<ShoppingListItemDTO> items;

    public ShoppingListDTO(ShoppingList list) {
        this.id = list.getId();
        this.name = list.getName();
        this.createdAt = list.getCreatedAt();
        this.items = list.getItems().stream()
                .map(ShoppingListItemDTO::new)
                .collect(Collectors.toList());
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

    public List<ShoppingListItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ShoppingListItemDTO> items) {
        this.items = items;
    }

}
