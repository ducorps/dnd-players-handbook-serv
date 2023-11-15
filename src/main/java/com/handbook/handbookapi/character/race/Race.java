package com.handbook.handbookapi.character.race;


import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "races")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_races")
public class Race extends AbstractEntity {

    @Column(name = "race_type")
    @Enumerated(EnumType.STRING)
    private RaceType raceType;
}
