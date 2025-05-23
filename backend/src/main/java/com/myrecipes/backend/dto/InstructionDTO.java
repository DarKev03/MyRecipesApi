package com.myrecipes.backend.dto;

import com.myrecipes.backend.entity.Instruction;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class InstructionDTO {
    private Long id;
    private String text;
    private Long recipeId;
    private Long userId;

    public InstructionDTO(Instruction instruction) {
        this.id = instruction.getId();
        this.text = instruction.getText();
        this.recipeId = instruction.getRecipe().getId();
        this.userId = instruction.getRecipe().getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
