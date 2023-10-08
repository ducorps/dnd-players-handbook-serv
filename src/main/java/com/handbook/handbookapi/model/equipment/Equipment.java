package com.handbook.handbookapi.model.equipment;

import com.handbook.handbookapi.model.Inventory;
import com.handbook.handbookapi.utils.AbstractEntity;
import com.handbook.handbookapi.model.price.Price;
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
public class Equipment extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToMany(mappedBy = "equipment", fetch = FetchType.LAZY)
    List<Inventory> inventories;
}
