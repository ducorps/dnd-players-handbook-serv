package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.exceptions.GameRuleException;
import com.handbook.handbookapi.character.Character;
import com.handbook.handbookapi.exceptions.GameRuleException;
import com.handbook.handbookapi.exceptions.MaximumWeightException;
import com.handbook.handbookapi.inventory.item.Item;
import com.handbook.handbookapi.inventory.item.ItemDTO;
import com.handbook.handbookapi.inventory.item.ItemService;
import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.LinkedHashMap;
import java.util.Objects;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.LinkedHashMap;
import java.util.Objects;

import java.util.Objects;

@Service
public class InventoryService extends AbstractService<Inventory, Long> {

    private static final String API_DND5E_URL = "https://www.dnd5eapi.co/api/";
    private static final String API_DND5E_EQUIPMENT_URL = API_DND5E_URL + "equipment/";

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
        if(Objects.nonNull(inventory.getId())) {
            if (itemService.getSumOfAllInventoryItems(inventory.getId()) > inventory.getCapacity()) {
                throw new MaximumWeightException();
            }
        }

        return super.save(inventory);
    }

    public Inventory createNewInventory(Character characterSaved) {
        Inventory inventory = new Inventory();

        inventory.setCharacter(characterSaved);
        inventory.setCapacity(0.0);

        return save(inventory);
    }

    public Inventory addItem(Long idInventory, String itemName) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<?, ?> json = restTemplate.getForObject(API_DND5E_EQUIPMENT_URL + itemName, LinkedHashMap.class);

        if(Objects.nonNull(json)) {
            ItemDTO itemDTO =  ItemDTO.fromApi(json);

            Inventory inventory = findById(idInventory);

            if (Objects.nonNull(inventory)) {
                Item item = itemDTO.toEntity();
                item.setInventory(inventory);

                itemService.save(item);
                inventoryRepository.save(inventory);
            } else {
                throw new GameRuleException("Inventory not found");
            }

            return inventory;
        } else {
            throw new GameRuleException("Item not found");
        }
    }

    private Inventory findById(Long idInventory) {
        return inventoryRepository.findById(idInventory).orElse(null);
    }

    public Inventory addItem(Long idInventory, String itemName) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<?, ?> json = restTemplate.getForObject(API_DND5E_EQUIPMENT_URL + itemName, LinkedHashMap.class);

        if(Objects.nonNull(json)) {
            ItemDTO itemDTO =  ItemDTO.fromApi(json);

            Inventory inventory = findById(idInventory);

            if (Objects.nonNull(inventory)) {
                Item item = itemDTO.toEntity();
                item.setInventory(inventory);

                itemService.save(item);
                inventoryRepository.save(inventory);
            } else {
                throw new GameRuleException("Inventory not found");
            }

            return inventory;
        } else {
            throw new GameRuleException("Item not found");
        }
    }
}
