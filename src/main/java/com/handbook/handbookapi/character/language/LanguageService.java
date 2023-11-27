package com.handbook.handbookapi.character.language;

import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService extends AbstractService<Language, Long> {

    @Autowired
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    protected LanguageRepository getRepository() {
        return languageRepository;
    }

    public Language findByLanguageType(LanguageType languageType) {
        return languageRepository.findByLanguageType(languageType);
    }
}
