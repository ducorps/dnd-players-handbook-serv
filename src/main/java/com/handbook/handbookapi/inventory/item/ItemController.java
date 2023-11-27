package com.handbook.handbookapi.inventory.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAll() {
        List<ItemDTO> items = itemService.findAllItemsInventory();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity deleteItem(Long idItem) {
        itemService.delete(idItem);

        return ResponseEntity.ok().build();
    }
}
