package com.handbook.handbookapi.character.race;

import com.handbook.handbookapi.common.AbilityType;
import com.mysema.commons.lang.Pair;
import lombok.Getter;

@Getter
public enum RaceType {

    HUMAN(new Pair<>(1, AbilityType.ALL), new Pair<>(null, null)),
    DWARF(new Pair<>(2, AbilityType.CONSTITUTION), new Pair<>(null,null)),
    ELF(new Pair<>(2, AbilityType.DEXTERITY), new Pair<>(null, null)),
    HALFLING(new Pair<>(2, AbilityType.DEXTERITY), new Pair<>(null, null)),
    DRAGONBORN(new Pair<>(2, AbilityType.STRENGTH), new Pair<>(1, AbilityType.CHARISMA)),
    GNOME(new Pair<>(2, AbilityType.INTELLIGENCE), new Pair<>(null, null)),
    HALF_ELF(new Pair<>(2, AbilityType.CHARISMA), new Pair<>(null, null)),
    HALF_ORC(new Pair<>(2, AbilityType.STRENGTH), new Pair<>(1, AbilityType.CONSTITUTION)),
    TIEFLING(new Pair<>(1, AbilityType.INTELLIGENCE), new Pair<>(2, AbilityType.CHARISMA));

    private Pair<Integer, AbilityType> mainAttributeModifier;
    private Pair<Integer, AbilityType> secondaryAttributeType;

    RaceType(Pair<Integer, AbilityType> mainAttributeModifier, Pair<Integer, AbilityType> secondaryAttributeType) {
        this.mainAttributeModifier = mainAttributeModifier;
        this.secondaryAttributeType = secondaryAttributeType;
    }


}
