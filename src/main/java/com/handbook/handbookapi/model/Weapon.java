package com.handbook.handbookapi.model;

import com.handbook.handbookapi.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weapon")
@PrimaryKeyJoinColumn(name="equipment_id")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_weapon")
public class Weapon extends Equipment {

    @Column(name = "damage", nullable = false)
    private Double damage;

    @Column(name = "properties")
    private String properties;

}
