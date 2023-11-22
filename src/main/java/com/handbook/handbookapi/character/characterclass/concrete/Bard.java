package com.handbook.handbookapi.character.characterclass.concrete;

import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.behaviors.ILevelUpBehavior;
import com.handbook.handbookapi.character.characterclass.behaviors.ILongRestBehavior;
import com.handbook.handbookapi.character.characterclass.behaviors.IShortRestBehavior;
import com.handbook.handbookapi.common.Die;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Bard extends CharacterClass implements ILevelUpBehavior, ILongRestBehavior, IShortRestBehavior {
    @Override
    public void levelUp() {

    }

    @Override
    public void longRest() {

    }

    @Override
    public void shortRest() {

    }

    @Override
    public Die getHitDie() {
        return new Die(8);
    }

}
