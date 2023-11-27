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
        List<InventoryDTO> inventoryDTO = InventoryDTO.fromEntity(inventories);

        return ResponseEntity.ok(inventoryDTO);
    }

    @GetMapping("/character/{idCharacter}")
    public ResponseEntity findAllByCharacterId(@PathVariable("idCharacter") Long idCharacter) {
        Inventory inventory = inventoryService.findByCharacterId(idCharacter);
        InventoryDTO inventoryDTO = InventoryDTO.fromEntity(inventory);

        return ResponseEntity.ok(inventoryDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<InventoryDTO> add(Inventory inventory) {
        Inventory savedInventory = inventoryService.save(inventory);
        InventoryDTO inventoryDTO = InventoryDTO.fromEntity(savedInventory);

        return ResponseEntity.ok(inventoryDTO);
    }

    @PostMapping("/{idInventory}/add-item")
    public ResponseEntity<InventoryDTO> addItem(@PathVariable("idInventory") Long idInventory,@RequestBody String itemName) {
        Inventory inventory = inventoryService.addItem(idInventory, itemName);
        InventoryDTO inventoryDTO = InventoryDTO.fromEntity(inventory);

        return ResponseEntity.ok(inventoryDTO);
    }
}
