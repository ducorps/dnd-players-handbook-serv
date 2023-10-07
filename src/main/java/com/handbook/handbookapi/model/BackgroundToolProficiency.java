package com.handbook.handbookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "background_tool_proficiency")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BackgroundToolProficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_background_tool_proficiency")
    @SequenceGenerator(name = "seq_background_tool_proficiency", sequenceName = "seq_background_tool_proficiency")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne
    @JoinColumn(name = "tool_proficiency_id")
    private ToolProficiency toolProficiency;
}
