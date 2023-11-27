package com.handbook.handbookapi.character;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class FinalStepDTO {
    private Integer intelligence;
    private Integer strength;
    private Integer constitution;
    private Integer wisdom;
    private Integer dexterity;
    private Integer charisma;
    private String name;
}