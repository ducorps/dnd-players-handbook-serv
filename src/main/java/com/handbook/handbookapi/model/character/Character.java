package com.handbook.handbookapi.model.character;

import com.handbook.handbookapi.model.Language;
import com.handbook.handbookapi.model.Race;
import com.handbook.handbookapi.model.Spell;
import com.handbook.handbookapi.model.User;
import com.handbook.handbookapi.model.background.Background;

import java.util.List;

public class Character {
    private String name;
    private ClassType classType;
    private Integer level;
    private Background background;
    private Race race;
    private User user;
    private Integer experience;
    private Integer proficiency;
    private Integer armorClass;
    private Integer iniciative;
    private Integer moveSpeed;
    private Integer life;
    private Integer temporaryLife;
    private String lifeDice;
    private String description;
    private List<Language> languages;
    private List<Spell> spells;
}
