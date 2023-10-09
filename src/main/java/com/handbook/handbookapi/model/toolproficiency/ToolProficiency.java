package com.handbook.handbookapi.model.toolproficiency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tool_proficiencie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToolProficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tool_proficiencies")
    @SequenceGenerator(name = "seq_tool_proficiencies", sequenceName = "seq_tool_proficiencies")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ToolProficiencyType name;
}
