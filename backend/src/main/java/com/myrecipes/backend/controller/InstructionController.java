package com.myrecipes.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrecipes.backend.dto.InstructionDTO;
import com.myrecipes.backend.service.InstructionService;

@RestController
@RequestMapping("/api/instructions")
@CrossOrigin(origins = "*")
public class InstructionController {

    private final InstructionService instructionService;

    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @GetMapping("/recipe/{recipeId}")
    public List<InstructionDTO> getByRecipe(@PathVariable Long recipeId) {
        return instructionService.getInstructionsByRecipeId(recipeId);
    }

    @PostMapping
    public InstructionDTO save(@RequestBody InstructionDTO instruction) {
        return instructionService.saveInstruction(instruction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        instructionService.deleteInstruction(id);
    }

    @GetMapping("/user/{userId}")
    public List<InstructionDTO> getByUser(@PathVariable Long userId) {
        return instructionService.getInstructionsByUserId(userId);
    }

    @PutMapping("/update")
    public InstructionDTO update(@RequestBody InstructionDTO instruction) {
        return instructionService.updateInstruction(instruction);
    }
}
