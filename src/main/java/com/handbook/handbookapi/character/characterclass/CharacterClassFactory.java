package com.handbook.handbookapi.character.characterclass;

import com.handbook.handbookapi.character.characterclass.concrete.*;
import com.handbook.handbookapi.exceptions.GameRuleException;
import org.springframework.beans.factory.annotation.Autowired;

public class CharacterClassFactory {

    public static CharacterClass getCharacterClass(CharacterClass characterClass) {
        return switch (characterClass.getClassType()) {
            case BARBARIAN -> new Barbarian();
            case BARD -> new Bard();
            case CLERIC -> new Cleric();
            case DRUID -> new Druid();
            case FIGHTER -> new Fighter();
            case MONK -> new Monk();
            case PALADIN -> new Paladin();
            case RANGER -> new Ranger();
            case ROGUE -> new Rogue();
            case SORCERER -> new Sorcerer();
            case WARLOCK -> new Warlock();
            case WIZARD -> new Wizard();
            default -> throw new GameRuleException("Characters need to have a game class.");
        };
    }
}
