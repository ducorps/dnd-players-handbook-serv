package com.handbook.handbookapi.background.skillproficiency;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillProficiencyRepository extends JpaRepository<SkillProficiency, Long>, CustomQuerydslPredicateExecutor<SkillProficiency> {
}
