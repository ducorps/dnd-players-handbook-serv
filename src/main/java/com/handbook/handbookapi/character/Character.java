package com.handbook.handbookapi.character;

import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.ICharacterClass;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.character.race.Race;
import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.skill.Skill;
import com.handbook.handbookapi.spell.Spell;
import com.handbook.handbookapi.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_characters")
public class Character extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_languages",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private List<Spell> spells;

    @OneToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "proficiency")
    private Integer proficiency;

    @Column(name = "armor_class")
    private Integer armorClass;

    @Column(name = "initiative")
    private Integer initiative;

    @Column(name = "move_speed")
    private Integer moveSpeed;

    @Column(name = "life")
    private Integer life;

    @Column(name = "temporary_life")
    private Integer temporaryLife;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "class_id")
    private CharacterClass classType;

    @Column(name = "level")
    private Integer level;

    @Column(name = "intelligence")
    private Integer intelligence;

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "constitution")
    private Integer constitution;

    @Column(name = "wisdom")
    private Integer wisdom;

    @Column(name = "dexterity")
    private Integer dexterity;

    @Column(name = "charisma")
    private Integer charisma;

    @Column(name = "is_completed")
    private Boolean isCompleted = Boolean.FALSE;

    public void setAllAttributes(Integer value) {
        this.intelligence = value;
        this.strength = value;
        this.constitution = value;
        this.wisdom = value;
        this.dexterity = value;
        this.charisma = value;
    }

    public void sumAttributes(Integer intelligence, Integer strength, Integer constitution,
                              Integer wisdom, Integer dexterity, Integer charisma) {
        this.intelligence += intelligence;
        this.strength += strength;
        this.constitution += constitution;
        this.wisdom += wisdom;
        this.dexterity += dexterity;
        this.charisma += charisma;
    }

    public void sumAllAttributes(Integer value) {
        this.intelligence += value;
        this.strength += value;
        this.constitution += value;
        this.wisdom += value;
        this.dexterity += value;
        this.charisma += value;
    }

    public void sumIntelligence(Integer intelligence) {
        this.intelligence += intelligence;
    }

    public void sumStrength(Integer strength) {
        this.strength += strength;
    }

    public void sumConstitution(Integer constitution) {
        this.constitution += constitution;
    }

    public void sumWisdom(Integer wisdom) {
        this.wisdom += wisdom;
    }

    public void sumDexterity(Integer dexterity) {
        this.dexterity += dexterity;
    }

    public void sumCharisma(Integer charisma) {
        this.charisma += charisma;
    }

    public List<Integer> getAllAttributes() {
        List<Integer> allAttributes = new ArrayList<>();

        allAttributes.add(this.intelligence);
        allAttributes.add(this.charisma);
        allAttributes.add(this.strength);
        allAttributes.add(this.wisdom);
        allAttributes.add(this.dexterity);
        allAttributes.add(this.constitution);

        return allAttributes;
    }
}
