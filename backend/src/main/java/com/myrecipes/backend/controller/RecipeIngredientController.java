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

import com.myrecipes.backend.dto.RecipeIngredientDTO;
import com.myrecipes.backend.service.RecipeIngredientService;

@RestController
@RequestMapping("/api/recipe-ingredients")
@CrossOrigin(origins = "*")
public class RecipeIngredientController {

    private final RecipeIngredientService service;

    public RecipeIngredientController(RecipeIngredientService service) {
        this.service = service;
    }

    @GetMapping("/{recipeId}")
    public List<RecipeIngredientDTO> getAll(@PathVariable Long recipeId) {
        return service.getByRecipeId(recipeId);
    }

    @PostMapping
    public RecipeIngredientDTO save(@RequestBody RecipeIngredientDTO ri) {
        return service.save(ri);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<RecipeIngredientDTO> getByUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @PostMapping("/update")
    public RecipeIngredientDTO update(@RequestBody RecipeIngredientDTO ri) {
        return service.update(ri);
    }
}
