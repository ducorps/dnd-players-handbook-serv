package com.handbook.handbookapi.model.background;

import com.handbook.handbookapi.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
