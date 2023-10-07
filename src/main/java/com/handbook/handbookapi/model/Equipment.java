package com.handbook.handbookapi.model;

import com.handbook.handbookapi.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;
}
