package com.handbook.handbookapi.repositories;

import com.handbook.handbookapi.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}