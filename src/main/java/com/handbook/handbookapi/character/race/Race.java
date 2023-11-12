package com.handbook.handbookapi.character.race;


import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "race")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_race")
public class Race extends AbstractEntity{
    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private RaceType race;
}
