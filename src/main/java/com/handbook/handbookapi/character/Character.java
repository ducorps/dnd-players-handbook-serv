package com.handbook.handbookapi.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.ICharacterClass;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.character.race.Race;
import com.handbook.handbookapi.character.race.RaceType;
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
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_characters", allocationSize = 1)
public class Character extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_id")
    private Background background;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_languages",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private List<Spell> spells;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
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

    @Column(name = "hit_die")
    private String hitDie;

    @Column(name = "temporary_life")
    private Integer temporaryLife;

    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;

    @Column(name = "level")
    private Integer level;

    @Column(name = "intelligence")
    private Integer intelligence = 0;

    @Column(name = "strength")
    private Integer strength = 0;

    @Column(name = "constitution")
    private Integer constitution = 0;

    @Column(name = "wisdom")
    private Integer wisdom = 0;

    @Column(name = "dexterity")
    private Integer dexterity = 0;

    @Column(name = "charisma")
    private Integer charisma = 0;

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
