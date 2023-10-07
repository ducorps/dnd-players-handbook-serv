package com.handbook.handbookapi.model;

import com.handbook.handbookapi.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "background")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_inventory")
public class Inventory extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @ManyToMany
    @JoinTable(
            name = "inventory_equipment",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> equipment;

    private Double availableWeight;

}
