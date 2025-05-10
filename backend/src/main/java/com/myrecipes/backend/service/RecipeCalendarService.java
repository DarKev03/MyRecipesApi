package com.myrecipes.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.entity.RecipeCalendar;
import com.myrecipes.backend.repository.RecipeCalendarRepository;

@Service
public class RecipeCalendarService {
    private final RecipeCalendarRepository calendarRepository;

    public RecipeCalendarService(RecipeCalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public List<RecipeCalendar> getAll() {
        return calendarRepository.findAll();
    }

    public RecipeCalendar save(RecipeCalendar calendar) {
        return calendarRepository.save(calendar);
    }

    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }
}
