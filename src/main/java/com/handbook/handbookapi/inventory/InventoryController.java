package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.character.Character;
import com.handbook.handbookapi.character.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity findAll() {
        List<Inventory> inventories = inventoryService.findAll();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/character/{idCharacter}")
    public ResponseEntity findAllByCharacterId(@PathVariable("idCharacter") Long idCharacter) {
        List<Inventory> inventory = inventoryService.findAllByCharacterId(idCharacter);
        List<InventoryDTO> inventoryDTO = InventoryDTO.fromEntity(inventory);

        return ResponseEntity.ok(inventoryDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<Inventory> add(Inventory inventory) {
        Inventory savedInventory = inventoryService.save(inventory);

        return ResponseEntity.ok(savedInventory);
    }

    @PostMapping("/{idInventory}/add-item")
    public ResponseEntity<Inventory> addItem(@PathVariable("idInventory") Long idInventory,@RequestBody String itemName) {
        Inventory inventory = inventoryService.addItem(idInventory, itemName);

        return ResponseEntity.ok(inventory);
    }
}
