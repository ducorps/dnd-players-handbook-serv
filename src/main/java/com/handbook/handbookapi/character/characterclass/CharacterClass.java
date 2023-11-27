package com.handbook.handbookapi.character.characterclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.common.Die;
import com.handbook.handbookapi.exceptions.GameRuleException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterClass extends AbstractEntity implements ICharacterClass  {

    @Column(name = "class_type")
    @Enumerated(EnumType.STRING)
    private ClassType classType;

    @Override
    public void performLevelUp() {
        throw new GameRuleException("There is no level up behavior for this game class.");
    }

    @Override
    public void performLongRest() {
        throw new GameRuleException("There is no long rest behavior for this game class.");
    }

    @Override
    public void performShortRest() {
        throw new GameRuleException("There is no short rest behavior for this game class.");
    }

    @JsonIgnore
    public Die getHitDie() {
        throw new GameRuleException("There is no hit die behavior for this game class.");
    }
}
