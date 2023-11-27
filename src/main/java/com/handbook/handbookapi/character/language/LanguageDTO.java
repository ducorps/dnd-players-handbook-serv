package com.handbook.handbookapi.character.language;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class LanguageDTO {
    private LanguageType languageType;

    public static LanguageDTO fromEntity(Language language) {
        if (Objects.isNull(language)) {
            return null;
        }
        LanguageDTO dto = new LanguageDTO();
        dto.setLanguageType(language.getLanguageType());

        return dto;
    }

    public Language toEntity() {
        Language language = new Language();
        language.setLanguageType(this.getLanguageType());

        return language;
    }

    public static List<LanguageDTO> fromEntity(List<Language> languages) {
        if(Objects.isNull(languages)) {
            return null;
        }
        return languages.stream().map(LanguageDTO::fromEntity).collect(Collectors.toList());
    }
}
