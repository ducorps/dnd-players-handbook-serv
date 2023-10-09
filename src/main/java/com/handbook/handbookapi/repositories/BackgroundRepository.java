package com.handbook.handbookapi.repositories;

import com.handbook.handbookapi.model.background.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends JpaRepository<Background, Long> {
}
