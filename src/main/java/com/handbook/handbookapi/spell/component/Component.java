package com.handbook.handbookapi.spell.component;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "components")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_components")
public class Component extends AbstractEntity {

    @Column(name = "component_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ComponentType componentType;
}
