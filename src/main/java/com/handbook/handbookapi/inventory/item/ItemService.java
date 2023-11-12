package com.handbook.handbookapi.inventory.item;

import com.handbook.handbookapi.inventory.InventoryRepository;
import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractService<Item, Long> {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    protected JpaRepository<Item, Long> getRepository() {
        return itemRepository;
    }

    public Double getSumOfAllInventoryEquipment(Long inventoryId) {
        return itemRepository
                .findAll(QItem.item.inventories.any().id.eq(inventoryId))
                .stream().mapToDouble(Item::getWeight)
                .sum();
    }
}
