package com.handbook.handbookapi.services;

import com.handbook.handbookapi.exceptions.MaximumWeightException;
import com.handbook.handbookapi.utils.AbstractService;
import com.handbook.handbookapi.model.Inventory;
import com.handbook.handbookapi.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class InventoryService extends AbstractService<Inventory, Long> {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemService itemService;

    @Override
    protected JpaRepository<Inventory, Long> getRepository() {
        return inventoryRepository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        if(itemService.getSumOfAllInventoryEquipment(inventory.getId()) > inventory.getCapacity()) {
            throw new MaximumWeightException();
        }

        return super.save(inventory);
    }
}
