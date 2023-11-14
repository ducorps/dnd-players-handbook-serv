package com.handbook.handbookapi.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<Inventory> add(Inventory inventory) {
        Inventory savedInventory = inventoryService.save(inventory);

        return ResponseEntity.ok(savedInventory);
    }
}
