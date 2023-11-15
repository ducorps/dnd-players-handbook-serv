package com.handbook.handbookapi.background.toolproficiency;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolProficiencyRepository extends JpaRepository<ToolProficiency, Long>, CustomQuerydslPredicateExecutor<ToolProficiency> {
}
