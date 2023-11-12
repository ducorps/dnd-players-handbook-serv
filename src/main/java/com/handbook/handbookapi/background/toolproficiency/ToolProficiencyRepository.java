package com.handbook.handbookapi.background.toolproficiency;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolProficiencyRepository extends JpaRepository<ToolProficiency, Long>, CustomQuerydslPredicateExecutor<ToolProficiency> {
}
