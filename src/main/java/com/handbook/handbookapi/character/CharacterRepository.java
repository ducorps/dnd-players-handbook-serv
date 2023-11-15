package com.handbook.handbookapi.character;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>, CustomQuerydslPredicateExecutor<Character> {
}
