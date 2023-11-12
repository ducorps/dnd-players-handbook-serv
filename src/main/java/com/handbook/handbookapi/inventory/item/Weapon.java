package com.handbook.handbookapi.inventory.item;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "weapon")
@PrimaryKeyJoinColumn(name="item_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_weapon")
public class Weapon extends Item {
    @Column(name = "damage", nullable = false)
    private Double damage;

    @Column(name = "properties")
    private String properties;

}
