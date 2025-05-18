package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.InstructionDTO;
import com.myrecipes.backend.entity.Instruction;
import com.myrecipes.backend.repository.InstructionRepository;

@Service
public class InstructionService {
    private final InstructionRepository instructionRepository;

    public InstructionService(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
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

    public Instruction saveInstruction(Instruction instruction) {

        return instructionRepository.save(instruction);
    }

    public void deleteInstruction(Long id) {
        instructionRepository.deleteById(id);
    }
}
