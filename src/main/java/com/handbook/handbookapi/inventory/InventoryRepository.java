package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.enterprise.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>, CustomQuerydslPredicateExecutor<Inventory> {
    Inventory findByCharacterId(Long idCharacter);
}
