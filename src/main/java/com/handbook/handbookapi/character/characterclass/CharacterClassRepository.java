package com.handbook.handbookapi.character.characterclass;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long>, CustomQuerydslPredicateExecutor<CharacterClass> {
    CharacterClass findByClassType(ClassType classType);
}
