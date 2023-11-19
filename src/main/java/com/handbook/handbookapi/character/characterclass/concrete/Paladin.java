package com.handbook.handbookapi.character.characterclass.concrete;

import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.behaviors.ILevelUpBehavior;
import com.handbook.handbookapi.character.characterclass.behaviors.ILongRestBehavior;
import com.handbook.handbookapi.character.characterclass.behaviors.IShortRestBehavior;

public class Paladin extends CharacterClass implements ILevelUpBehavior, ILongRestBehavior, IShortRestBehavior {
    @Override
    public void levelUp() {

    }

    @Override
    public void longRest() {

    }

    @Override
    public void shortRest() {

    }
}
