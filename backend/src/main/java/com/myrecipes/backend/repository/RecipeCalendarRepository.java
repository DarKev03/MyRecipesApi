package com.myrecipes.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.RecipeCalendar;

public interface RecipeCalendarRepository extends JpaRepository<RecipeCalendar, Long> {
    List<RecipeCalendar> findByUserId(Long userId);
}
