package com.handbook.handbookapi.inventory.item;

import com.handbook.handbookapi.inventory.Inventory;
import com.handbook.handbookapi.common.AbstractEntity;
import com.handbook.handbookapi.value.Value;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_items")
public class Item extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "value_id")
    private Value value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Item(String name, Integer weight, Value value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}
