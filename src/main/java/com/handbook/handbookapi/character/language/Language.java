package com.handbook.handbookapi.character.language;

import com.handbook.handbookapi.commom.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "language")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_language")
public class Language extends AbstractEntity {
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private LanguageType language;
}
