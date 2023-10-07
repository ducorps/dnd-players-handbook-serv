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
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_background")
public class Background extends AbstractEntity {

    @Column(name = "background_type", nullable = false)
    private BackgroundType backgroundType;

    @Column(name = "extra_languages")
    private Integer extraLanguages;
}
