package com.myrecipes.backend.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.IngredientDTO;
import com.myrecipes.backend.entity.Ingredient;
import com.myrecipes.backend.repository.IngredientRepository;

import jakarta.transaction.Transactional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(IngredientDTO::new)
                .toList();
    }

    public Optional<IngredientDTO> getIngredientById(Long id) {
        return ingredientRepository.findById(id).map(IngredientDTO::new);
    }

    @Transactional
    public IngredientDTO saveIngredient(IngredientDTO ingredientDTO) {
        Optional<Ingredient> existing = ingredientRepository.findByName(ingredientDTO.getName());

        if (existing.isPresent()) {
            return new IngredientDTO(existing.get());
        } else {
            Ingredient savedIngredient = new Ingredient();
            savedIngredient.setName(ingredientDTO.getName());
            savedIngredient.setDescription(ingredientDTO.getDescription());
            savedIngredient.setCreatedAt(OffsetDateTime.now());

            return new IngredientDTO(ingredientRepository.saveAndFlush(savedIngredient));
        }
    }

    @Transactional
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

}
