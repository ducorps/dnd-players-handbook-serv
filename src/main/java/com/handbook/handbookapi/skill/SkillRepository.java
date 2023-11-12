package com.handbook.handbookapi.skill;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long>, CustomQuerydslPredicateExecutor<Skill> {
}
