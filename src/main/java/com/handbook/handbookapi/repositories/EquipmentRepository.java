package com.handbook.handbookapi.repositories;

import com.handbook.handbookapi.model.equipment.Equipment;
import com.handbook.handbookapi.utils.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>, CustomQuerydslPredicateExecutor<Equipment> {
}
