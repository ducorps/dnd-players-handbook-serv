package com.handbook.handbookapi.user.role;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_roles")
public class Role extends AbstractEntity {

    @Column(name = "role_type", length = 20)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
