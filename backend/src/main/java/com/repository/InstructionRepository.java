package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Instruction;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {
}
