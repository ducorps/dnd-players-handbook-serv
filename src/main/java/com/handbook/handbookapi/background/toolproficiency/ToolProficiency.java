package com.handbook.handbookapi.background.toolproficiency;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tool_proficiency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_tool_proficiency")
public class ToolProficiency extends AbstractEntity {
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ToolProficiencyType type;
}
