package com.handbook.handbookapi.value;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long>, CustomQuerydslPredicateExecutor<Value> {
}
