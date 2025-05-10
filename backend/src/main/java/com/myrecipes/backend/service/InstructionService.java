package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.entity.Instruction;
import com.myrecipes.backend.repository.InstructionRepository;

@Service
public class InstructionService {
    private final InstructionRepository instructionRepository;

    public InstructionService(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    public List<Instruction> getAllInstructions() {
        return instructionRepository.findAll();
    }

    public Optional<Instruction> getInstructionsById(Long id) {
        return instructionRepository.findById(id);
    }

    public List<Instruction> getInstructionsByRecipeId(Long recipeId) {
        return instructionRepository.findByRecipeId(recipeId);
    }

    public Instruction saveInstruction(Instruction instruction) {

        return instructionRepository.save(instruction);
    }

    public void deleteInstruction(Long id) {
        instructionRepository.deleteById(id);
    }
}
