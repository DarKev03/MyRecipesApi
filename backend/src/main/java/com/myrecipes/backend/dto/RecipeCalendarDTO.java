package com.myrecipes.backend.dto;

import java.time.LocalDate;

import com.myrecipes.backend.entity.RecipeCalendar;

public class RecipeCalendarDTO {
    private Long id;
    private String recipeTitle;
    private LocalDate scheduledDate;
    private String notes;

    public RecipeCalendarDTO(RecipeCalendar rc) {
        this.id = rc.getId();
        this.recipeTitle = rc.getRecipe().getTitle();
        this.scheduledDate = rc.getScheduledDate();
        this.notes = rc.getNotes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
