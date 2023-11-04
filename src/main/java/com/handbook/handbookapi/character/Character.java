package com.handbook.handbookapi.character;

import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.character.race.Race;
import com.handbook.handbookapi.commom.AbstractEntity;
import com.handbook.handbookapi.skill.Skill;
import com.handbook.handbookapi.spell.Spell;
import com.handbook.handbookapi.user.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_character")
public class Character extends AbstractEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_skill",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_language",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_spell",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private List<Spell> spells;

    @OneToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @Column(name = "proficiency", nullable = false)
    private Integer proficiency;

    @Column(name = "armor_class", nullable = false)
    private Integer armorClass;

    @Column(name = "initiative", nullable = false)
    private Integer initiative;

    @Column(name = "move_speed", nullable = false)
    private Integer moveSpeed;

    @Column(name = "life", nullable = false)
    private Integer life;

    @Column(name = "temporary_life", nullable = false)
    private Integer temporaryLife;

    @Column(name = "life_dice", nullable = false)
    private String lifeDice;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "class_type", nullable = false)
    private ClassType classType;

    @Column(name = "level", nullable = false)
    private Integer level;
}
