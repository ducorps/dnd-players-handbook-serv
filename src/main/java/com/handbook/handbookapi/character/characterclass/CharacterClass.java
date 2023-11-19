package com.handbook.handbookapi.character.characterclass;

import com.handbook.handbookapi.character.ClassType;
import com.handbook.handbookapi.exceptions.GameRuleException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CharacterClass implements ICharacterClass{

    private ICharacterClass characterClass;

    private ClassType classType;

    private String hitDie;

    private Integer baseHealth;

    @Override
    public void performLevelUp() {
        throw new GameRuleException("There ");
    }

    @Override
    public void performLongRest() {

    }

    @Override
    public void performShortRest() {

    }
}
