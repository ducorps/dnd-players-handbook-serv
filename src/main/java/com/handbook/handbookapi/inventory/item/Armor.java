package com.handbook.handbookapi.inventory.item;


import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.inventory.Inventory;
import com.handbook.handbookapi.value.Value;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "armors")
@PrimaryKeyJoinColumn(name="item_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_armors")
public class Armor extends Item {

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "stealth", nullable = false)
    private Boolean stealth;

    @Column(name = "armor_class", nullable = false)
    private Integer armorClass;

    @Column(name = "armor_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ArmorType armorType;

    public Armor(String name, Integer weight, Value value, Integer strength, Boolean stealth, Integer armorClass, ArmorType armorType) {
        super(name, weight, value);
        this.strength = strength;
        this.stealth = stealth;
        this.armorClass = armorClass;
        this.armorType = armorType;
    }
}
