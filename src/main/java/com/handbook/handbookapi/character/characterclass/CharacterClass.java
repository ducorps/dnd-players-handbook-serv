package com.handbook.handbookapi.character.characterclass;

import com.handbook.handbookapi.character.ClassType;
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
        throw new GameRuleException("Não existe comportamento de level up para essa classe.");
    }

    @Override
    public void performLongRest() {
        throw new GameRuleException("Não existe comportamento de long rest para essa classe.");
    }

    @Override
    public void performShortRest() {
        throw new GameRuleException("Não existe comportamento de short rest para essa classe.");
    }

    public Die getHitDie() {
        throw new GameRuleException("Não existe dado de vida para essa classe.");
    }
}
