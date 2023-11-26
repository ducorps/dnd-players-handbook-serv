package com.handbook.handbookapi.character.characterclass;

import com.handbook.handbookapi.character.ClassType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterClassDTO {

    private ClassType classType;

    public static CharacterClassDTO fromEntity(CharacterClass characterClass) {
        CharacterClassDTO dto = new CharacterClassDTO();
        dto.setClassType(characterClass.getClassType());

        return dto;
    }

    public CharacterClass toEntity() {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setClassType(this.getClassType());

        return characterClass;
    }
}
