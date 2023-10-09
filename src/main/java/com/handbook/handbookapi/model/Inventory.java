package com.handbook.handbookapi.model;

import com.handbook.handbookapi.utils.AbstractEntity;
import com.handbook.handbookapi.model.character.Character;
import com.handbook.handbookapi.model.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_inventory")
public class Inventory extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "inventory_item",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    private Double capacity;
}
