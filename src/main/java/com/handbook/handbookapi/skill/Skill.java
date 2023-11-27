package com.handbook.handbookapi.skill;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_skills")
public class Skill extends AbstractEntity {

    @Column(name = "acrobatics", nullable = false)
    private Integer acrobatics;

    @Column(name = "animal_handling", nullable = false)
    private Integer animalhandling;

    @Column(name = "arcana", nullable = false)
    private Integer arcana;

    @Column(name = "athletics", nullable = false)
    private Integer athletics;

    @Column(name = "performance", nullable = false)
    private Integer performance;

    @Column(name = "stealth", nullable = false)
    private Integer stealth;

    @Column(name = "history", nullable = false)
    private Integer history;

    @Column(name = "intimidation", nullable = false)
    private Integer intimidation;

    @Column(name = "medicine", nullable = false)
    private Integer medicine;

    @Column(name = "nature", nullable = false)
    private Integer nature;

    @Column(name = "perception", nullable = false)
    private Integer perception;

    @Column(name = "persuasion", nullable = false)
    private Integer persuasion;

    @Column(name = "sleight_of_hand", nullable = false)
    private Integer sleightofhand;

    @Column(name = "investigation", nullable = false)
    private Integer investigation;

    @Column(name = "religion", nullable = false)
    private Integer religion;

    @Column(name = "insight", nullable = false)
    private Integer insight;

    @Column(name = "survival", nullable = false)
    private Integer survival;

    @Column(name = "deception", nullable = false)
    private Integer deception;

    public Skill (Integer startValue) {
        this.acrobatics = startValue;
        this.animalhandling = startValue;
        this.arcana = startValue;
        this.athletics = startValue;
        this.performance = startValue;
        this.stealth = startValue;
        this.history = startValue;
        this.intimidation = startValue;
        this.medicine = startValue;
        this.nature = startValue;
        this.perception = startValue;
        this.persuasion = startValue;
        this.sleightofhand = startValue;
        this.investigation = startValue;
        this.religion = startValue;
        this.insight = startValue;
        this.survival = startValue;
        this.deception = startValue;
    }
}
