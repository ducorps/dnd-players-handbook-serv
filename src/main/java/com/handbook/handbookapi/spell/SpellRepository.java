package com.handbook.handbookapi.spell;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository extends JpaRepository<Spell, Long>, CustomQuerydslPredicateExecutor<Spell> {
}
