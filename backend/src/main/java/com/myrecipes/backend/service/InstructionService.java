package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.InstructionDTO;
import com.myrecipes.backend.entity.Instruction;
import com.myrecipes.backend.repository.InstructionRepository;
import com.myrecipes.backend.repository.RecipeRepository;

@Service
public class InstructionService {
    private final InstructionRepository instructionRepository;
    private final RecipeRepository recipeRepository;

    public InstructionService(InstructionRepository instructionRepository, RecipeRepository recipeRepository) {
        this.instructionRepository = instructionRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<InstructionDTO> getAllInstructions() {
        return instructionRepository.findAll().stream()
                .map(InstructionDTO::new)
                .toList();
    }

    public Optional<InstructionDTO> getInstructionsById(Long id) {
        return instructionRepository.findById(id).map(InstructionDTO::new);
    }

    public List<InstructionDTO> getInstructionsByRecipeId(Long recipeId) {
        return instructionRepository.findByRecipeId(recipeId).stream()
                .map(InstructionDTO::new)
                .toList();
    }

    public InstructionDTO saveInstruction(InstructionDTO instruction) {
        Instruction savedInstruction = new Instruction();
        savedInstruction.setText(instruction.getText());
        savedInstruction.setRecipe(recipeRepository.findById(instruction.getRecipeId()).get());        
        
        return new InstructionDTO(instructionRepository.save(savedInstruction));
    }

    public void deleteInstruction(Long id) {
        instructionRepository.deleteById(id);
    }

    public List<InstructionDTO> getInstructionsByUserId(Long userId) {
        return instructionRepository.findByRecipe_User_Id(userId).stream()
                .map(InstructionDTO::new)
                .toList();
    }
}
