package com.myrecipes.backend.dto;

import com.myrecipes.backend.entity.Instruction;

public class InstructionDTO {
    private Long id;
    private String text;

    public InstructionDTO(Instruction instruction) {
        this.id = instruction.getId();
        this.text = instruction.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
