package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeCalendarDTO;
import com.myrecipes.backend.entity.Recipe;
import com.myrecipes.backend.entity.RecipeCalendar;
import com.myrecipes.backend.repository.RecipeCalendarRepository;
import com.myrecipes.backend.repository.RecipeRepository;
import com.myrecipes.backend.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RecipeCalendarService {
    private final RecipeCalendarRepository calendarRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public RecipeCalendarService(RecipeCalendarRepository calendarRepository, RecipeRepository recipeRepository,
            UserRepository userRepository) {
        this.calendarRepository = calendarRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
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
        recipeCalendarSaved.setUser(userRepository.findById(calendar.getUserId()).get());
        return new RecipeCalendarDTO(calendarRepository.save(recipeCalendarSaved));
    }

    @Transactional
    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }

    public List<RecipeCalendarDTO> findByUser(Long userId) {
        return calendarRepository.findByUserId(userId).stream()
                .map(calendar -> {
                    String recipeTitle = recipeRepository.findById(calendar.getRecipe().getId())
                            .map(Recipe::getTitle)
                            .orElse("Sin título");

                    RecipeCalendarDTO dto = new RecipeCalendarDTO(calendar);
                    dto.setRecipeTitle(recipeTitle);
                    return dto;
                })
                .toList();
    }
}
