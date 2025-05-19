package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.RecipeCalendarDTO;
import com.myrecipes.backend.entity.RecipeCalendar;
import com.myrecipes.backend.repository.RecipeCalendarRepository;

@Service
public class RecipeCalendarService {
    private final RecipeCalendarRepository calendarRepository;

    public RecipeCalendarService(RecipeCalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public List<RecipeCalendarDTO> getAll() {
        return calendarRepository.findAll().stream()
                .map(RecipeCalendarDTO::new)
                .toList();
    }

    public RecipeCalendarDTO save(RecipeCalendar calendar) {
        RecipeCalendar recipeCalendarSaved = calendarRepository.save(calendar);
        return new RecipeCalendarDTO(recipeCalendarSaved);
    }

    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }
}
