package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.exceptions.MaximumWeightException;
import com.handbook.handbookapi.inventory.item.ItemService;
import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
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
        if(itemService.getSumOfAllInventoryItems(inventory.getId()) > inventory.getCapacity()) {
            throw new MaximumWeightException();
        }

        return super.save(inventory);
    }
}
