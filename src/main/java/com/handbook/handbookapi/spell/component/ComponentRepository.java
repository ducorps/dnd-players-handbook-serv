package com.handbook.handbookapi.spell.component;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long>, CustomQuerydslPredicateExecutor<Component> {
}
