package com.handbook.handbookapi.controllers;

import com.handbook.handbookapi.exceptions.MaximumWeightException;
import com.handbook.handbookapi.model.Inventory;
import com.handbook.handbookapi.services.EquipmentService;
import com.handbook.handbookapi.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/add")
    public ResponseEntity<Inventory> add(Inventory inventory) throws MaximumWeightException {
        if(equipmentService.getSumOfAllInventoryEquipment(inventory.getId()) > inventory.getCapacity()) {
            throw new MaximumWeightException();
        }

        Inventory savedInventory = inventoryService.save(inventory);

        return ResponseEntity.ok(savedInventory);
    }
}
