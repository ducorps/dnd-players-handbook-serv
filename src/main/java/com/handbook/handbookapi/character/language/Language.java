package com.handbook.handbookapi.character.language;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_languages", allocationSize = 1)
public class Language extends AbstractEntity {

    @Column(name = "language_type")
    @Enumerated(EnumType.STRING)
    private LanguageType languageType;
}