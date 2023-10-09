package com.handbook.handbookapi.model.equipment;


import com.handbook.handbookapi.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "armor")
@PrimaryKeyJoinColumn(name="equipment_id")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_armor")
public class Armor extends Equipment {

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "stealth", nullable = false)
    private Boolean stealth;

    @Column(name = "armor_class", nullable = false)
    private Integer armorClass;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ArmorType type;

}
