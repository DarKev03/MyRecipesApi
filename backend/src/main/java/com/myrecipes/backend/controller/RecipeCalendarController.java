package com.myrecipes.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrecipes.backend.dto.RecipeCalendarDTO;
import com.myrecipes.backend.entity.RecipeCalendar;
import com.myrecipes.backend.service.RecipeCalendarService;

@RestController
@RequestMapping("/api/calendar")
@CrossOrigin(origins = "*")
public class RecipeCalendarController {

    private final RecipeCalendarService service;

    public RecipeCalendarController(RecipeCalendarService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecipeCalendarDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public RecipeCalendarDTO save(@RequestBody RecipeCalendar calendar) {
        return service.save(calendar);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
