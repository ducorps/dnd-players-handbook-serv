package com.handbook.handbookapi.character.language;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>, CustomQuerydslPredicateExecutor<Language> {

    Language findByLanguageType(LanguageType languageType);
}
