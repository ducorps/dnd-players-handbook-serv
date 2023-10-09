package com.handbook.handbookapi.model;

import com.handbook.handbookapi.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "spell")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_spell")
public class Spell extends AbstractEntity {
    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "casting_time", nullable = false)
    private Integer castingTime;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "range", nullable = false)
    private Double range;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "component", nullable = false)
    private ComponentType componentType;

    @Column(name = "necessary_objects")
    private String necessaryObject;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "spell_component",
//            joinColumns = @JoinColumn(name = "spell_id"),
//            inverseJoinColumns = @JoinColumn(name = "component_id")
//    )
}
