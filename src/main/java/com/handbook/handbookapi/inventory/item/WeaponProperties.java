package com.handbook.handbookapi.inventory.item;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "weapon_properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_weapon_properties")
public class WeaponProperties extends AbstractEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
}
