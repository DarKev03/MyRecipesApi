package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeCalendarDTO;
import com.myrecipes.backend.entity.RecipeCalendar;
import com.myrecipes.backend.repository.RecipeCalendarRepository;
import com.myrecipes.backend.repository.RecipeRepository;

import jakarta.transaction.Transactional;

@Service
public class RecipeCalendarService {
    private final RecipeCalendarRepository calendarRepository;
    private final RecipeRepository recipeRepository;

    public RecipeCalendarService(RecipeCalendarRepository calendarRepository, RecipeRepository recipeRepository) {
        this.calendarRepository = calendarRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeCalendarDTO> getAll() {
        return calendarRepository.findAll().stream()
                .map(RecipeCalendarDTO::new)
                .toList();
    }

    @Transactional
    public RecipeCalendarDTO save(RecipeCalendarDTO calendar) {
        RecipeCalendar recipeCalendarSaved = new RecipeCalendar();
        recipeCalendarSaved.setNotes(calendar.getNotes());
        recipeCalendarSaved.setScheduledDate(calendar.getScheduledDate());
        recipeCalendarSaved.setRecipe(recipeRepository.findById(calendar.getRecipeId()).get());
        return new RecipeCalendarDTO(calendarRepository.save(recipeCalendarSaved));
    }

    @Transactional
    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }
}
