package com.handbook.handbookapi.inventory.item;

import com.handbook.handbookapi.inventory.InventoryRepository;
import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Double getSumOfAllInventoryItems(Long inventoryId) {
        return itemRepository
                .findAll(QItem.item.inventories.any().id.eq(inventoryId))
                .stream().mapToDouble(Item::getWeight)
                .sum();
    }

    public List<ItemDTO> findAllItemsInventory() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemDTOs = new ArrayList<>();
        items.stream().forEach(item -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setType(item.getClass().getSimpleName().toUpperCase());
            itemDTO.setName(item.getName());
            itemDTO.setWeight(item.getWeight());
            itemDTO.setValue(item.getValue());

            if (item instanceof Armor) {
                itemDTO.setArmorClass(((Armor) item).getArmorClass());
                itemDTO.setStrength(((Armor) item).getStrength());
                itemDTO.setArmorType(((Armor) item).getArmorType());
                itemDTO.setStealth(((Armor) item).getStealth());
            }

            if (item instanceof Weapon) {
                itemDTO.setDamage(((Weapon) item).getDamage());
                itemDTO.setProperties(((Weapon) item).getProperties());
            }
            itemDTOs.add(itemDTO);
        });

        return itemDTOs;

    }
}
