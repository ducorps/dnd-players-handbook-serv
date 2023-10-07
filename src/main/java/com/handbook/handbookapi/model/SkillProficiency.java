package com.handbook.handbookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skill_proficiency")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkillProficiency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_skill_proficiencies")
    @SequenceGenerator(name = "seq_skill_proficiencies", sequenceName = "seq_skill_proficiencies")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "skill_proficiency")
    @Enumerated(EnumType.STRING)
    private SkillProficiencyType value;
}
