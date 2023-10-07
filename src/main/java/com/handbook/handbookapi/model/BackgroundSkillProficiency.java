package com.handbook.handbookapi.model;

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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_background_skill_proficiency")
    @SequenceGenerator(name = "seq_background_skill_proficiency", sequenceName = "seq_background_skill_proficiency")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne
    @JoinColumn(name = "skill_proficiency_id")
    private SkillProficiency skillProficiency;
}
