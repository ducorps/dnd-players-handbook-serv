package com.handbook.handbookapi.model.background;

import com.handbook.handbookapi.model.SkillProficiency;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BackgroudSkillProficiencyKey {

    @Column(name = "background_id")
    private Long backgroundId;

    @Column(name = "skill_proficiency_id")
    private Long skillProficiencyId;
}
