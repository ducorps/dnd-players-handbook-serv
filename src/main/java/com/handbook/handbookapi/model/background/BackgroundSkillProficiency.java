package com.handbook.handbookapi.model.background;

import com.handbook.handbookapi.model.SkillProficiency;
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
    private BackgroudSkillProficiencyKey id;

    @ManyToOne
    @MapsId("backgroundId")
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne
    @MapsId("skillProficiencyId")
    @JoinColumn(name = "skill_proficiency_id")
    private SkillProficiency skillProficiency;
}
