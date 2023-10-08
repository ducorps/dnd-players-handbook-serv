package com.handbook.handbookapi.services;

import com.handbook.handbookapi.model.QInventory;
import com.handbook.handbookapi.model.equipment.Equipment;
import com.handbook.handbookapi.model.equipment.QEquipment;
import com.handbook.handbookapi.repositories.EquipmentRepository;
import com.handbook.handbookapi.repositories.InventoryRepository;
import com.handbook.handbookapi.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService extends AbstractService<Equipment, Long> {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    protected JpaRepository<Equipment, Long> getRepository() {
        return equipmentRepository;
    }

    public Double getSumOfAllInventoryEquipment(Long inventoryId) {
        return equipmentRepository
                .findAll(QEquipment.equipment.inventories.any().id.eq(inventoryId))
                .stream().mapToDouble(Equipment::getWeight)
                .sum();
    }
}