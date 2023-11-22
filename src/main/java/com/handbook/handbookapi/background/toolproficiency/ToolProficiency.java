package com.handbook.handbookapi.background.toolproficiency;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tool_proficiencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_tool_proficiencies")
public class ToolProficiency extends AbstractEntity {

    @Column(name = "tool_proficiency_type")
    @Enumerated(EnumType.STRING)
    private ToolProficiencyType toolProficiencyType;
}
