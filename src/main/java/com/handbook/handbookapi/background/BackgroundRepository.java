package com.handbook.handbookapi.background;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackgroundRepository extends JpaRepository<Background, Long>, CustomQuerydslPredicateExecutor<Background> {
    Background findFirstByBackgroundType(BackgroundType backgroundType);
}
