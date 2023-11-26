package com.handbook.handbookapi.skill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO {
    private Integer acrobatics;
    private Integer animalHandling;
    private Integer arcana;
    private Integer athletics;
    private Integer performance;
    private Integer stealth;
    private Integer history;
    private Integer intimidation;
    private Integer medicine;
    private Integer nature;
    private Integer perception;
    private Integer persuasion;
    private Integer sleightOfHand;
    private Integer investigation;
    private Integer religion;
    private Integer insight;
    private Integer survival;
    private Integer deception;

    public static SkillDTO fromEntity(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setAcrobatics(skill.getAcrobatics());
        dto.setAnimalHandling(skill.getAnimalHandling());
        dto.setArcana(skill.getArcana());
        dto.setAthletics(skill.getAthletics());
        dto.setPerformance(skill.getPerformance());
        dto.setStealth(skill.getStealth());
        dto.setHistory(skill.getHistory());
        dto.setIntimidation(skill.getIntimidation());
        dto.setMedicine(skill.getMedicine());
        dto.setNature(skill.getNature());
        dto.setPerception(skill.getPerception());
        dto.setPersuasion(skill.getPersuasion());
        dto.setSleightOfHand(skill.getSleightOfHand());
        dto.setInvestigation(skill.getInvestigation());
        dto.setReligion(skill.getReligion());
        dto.setInsight(skill.getInsight());
        dto.setSurvival(skill.getSurvival());
        dto.setDeception(skill.getDeception());

        return dto;
    }

    public Skill toEntity() {
        Skill skill = new Skill();
        skill.setAcrobatics(this.getAcrobatics());
        skill.setAnimalHandling(this.getAnimalHandling());
        skill.setArcana(this.getArcana());
        skill.setAthletics(this.getAthletics());
        skill.setPerformance(this.getPerformance());
        skill.setStealth(this.getStealth());
        skill.setHistory(this.getHistory());
        skill.setIntimidation(this.getIntimidation());
        skill.setMedicine(this.getMedicine());
        skill.setNature(this.getNature());
        skill.setPerception(this.getPerception());
        skill.setPersuasion(this.getPersuasion());
        skill.setSleightOfHand(this.getSleightOfHand());
        skill.setInvestigation(this.getInvestigation());
        skill.setReligion(this.getReligion());
        skill.setInsight(this.getInsight());
        skill.setSurvival(this.getSurvival());
        skill.setDeception(this.getDeception());

        return skill;
    }
}
