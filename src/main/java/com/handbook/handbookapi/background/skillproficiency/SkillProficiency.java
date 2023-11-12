package com.handbook.handbookapi.background.skillproficiency;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skill_proficiency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_skill_proficiency")
public class SkillProficiency extends AbstractEntity {
    @Column(name = "skill_proficiency")
    @Enumerated(EnumType.STRING)
    private SkillProficiencyType type;
}
