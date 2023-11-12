package com.handbook.handbookapi.character.race;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long>, CustomQuerydslPredicateExecutor<Race> {
}
