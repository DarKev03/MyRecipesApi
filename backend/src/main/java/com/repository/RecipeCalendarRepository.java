package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.RecipeCalendar;

public interface RecipeCalendarRepository extends JpaRepository<RecipeCalendar, Long> {
}
