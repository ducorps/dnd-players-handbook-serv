package com.handbook.handbookapi.character.language;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long>, CustomQuerydslPredicateExecutor<Language> {
}
