package com.handbook.handbookapi.background.skillproficiency;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillProficiencyRepository extends JpaRepository<SkillProficiency, Long>, CustomQuerydslPredicateExecutor<SkillProficiency> {
}
