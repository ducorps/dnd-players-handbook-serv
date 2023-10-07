package com.handbook.handbookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "background")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Background {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_background")
    @SequenceGenerator(name = "seq_background", sequenceName = "seq_background")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "background_type", nullable = false)
    private BackgroundType backgroundType;

    @Column(name = "extra_languages")
    private Integer extraLanguages;
}
