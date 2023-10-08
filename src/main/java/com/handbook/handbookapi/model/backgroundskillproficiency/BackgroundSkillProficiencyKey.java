package com.handbook.handbookapi.model.backgroundskillproficiency;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BackgroundSkillProficiencyKey {

    @Column(name = "background_id")
    private Long backgroundId;

    @Column(name = "skill_proficiency_id")
    private Long skillProficiencyId;
}
