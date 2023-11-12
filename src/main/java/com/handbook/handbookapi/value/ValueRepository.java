package com.handbook.handbookapi.value;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, Long>, CustomQuerydslPredicateExecutor<Value> {
}
