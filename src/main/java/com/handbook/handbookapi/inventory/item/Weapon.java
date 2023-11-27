package com.handbook.handbookapi.inventory.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.inventory.Inventory;
import com.handbook.handbookapi.value.Value;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weapons")
@PrimaryKeyJoinColumn(name="item_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_weapons")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Weapon extends Item {

    @Column(name = "damage", nullable = false)
    private String damage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "weapon", cascade = CascadeType.ALL)
    private List<WeaponProperties> properties;

    public Weapon(String name, Integer weight, Value value,  String damage, List<WeaponProperties> properties) {
        super(name, weight, value);
        this.damage = damage;
        this.properties = properties;
    }
}
