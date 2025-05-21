package com.myrecipes.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrecipes.backend.entity.Instruction;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    List<Instruction> findByRecipeId(Long recipeId);
    List<Instruction> findByRecipe_User_Id(Long userId);
}
