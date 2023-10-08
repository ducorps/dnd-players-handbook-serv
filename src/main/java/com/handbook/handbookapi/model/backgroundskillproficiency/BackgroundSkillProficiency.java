package com.handbook.handbookapi.model.backgroundskillproficiency;

import com.handbook.handbookapi.model.skillproficiency.SkillProficiency;
import com.handbook.handbookapi.model.background.Background;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "background_skill_proficiency")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BackgroundSkillProficiency {

    @EmbeddedId
    private BackgroundSkillProficiencyKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("backgroundId")
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("skillProficiencyId")
    @JoinColumn(name = "skill_proficiency_id")
    private SkillProficiency skillProficiency;
}
