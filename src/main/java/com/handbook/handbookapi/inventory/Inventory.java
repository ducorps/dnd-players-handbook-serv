package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.character.Character;
import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.inventory.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_inventories")
public class Inventory extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "inventory_items",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    private Double capacity;
}
