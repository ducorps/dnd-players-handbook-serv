package com.handbook.handbookapi.model.item;

import com.handbook.handbookapi.model.Inventory;
import com.handbook.handbookapi.utils.AbstractEntity;
import com.handbook.handbookapi.model.value.Value;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends AbstractEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "value_id")
    private Value value;

    @ManyToMany(mappedBy = "item", fetch = FetchType.LAZY)
    List<Inventory> inventories;
}
