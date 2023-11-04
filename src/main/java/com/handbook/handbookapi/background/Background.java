package com.handbook.handbookapi.background;

import com.handbook.handbookapi.background.skillproficiency.SkillProficiency;
import com.handbook.handbookapi.background.toolproficiency.ToolProficiency;
import com.handbook.handbookapi.commom.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "background")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_background")
public class Background extends AbstractEntity {
    @Column(name = "background_type", nullable = false)
    private BackgroundType backgroundType;

    @Column(name = "extra_languages")
    private Integer extraLanguages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "background_skill_proficiency",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_proficiency_id"))
    private List<SkillProficiency> skillProficiencies;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "background_tool_proficiency",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_proficiency_id"))
    private List<ToolProficiency> toolProficiencies;
}
