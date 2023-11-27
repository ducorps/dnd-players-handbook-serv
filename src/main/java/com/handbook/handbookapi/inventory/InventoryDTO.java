package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.inventory.item.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class InventoryDTO {
    private Long id;
    private List<ItemDTO> items;
    private Double capacity;

    public static InventoryDTO fromEntity(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(inventory.getId());
        dto.setCapacity(inventory.getCapacity());
        dto.setItems(ItemDTO.fromEntity(inventory.getItems()));
        return dto;
    }

    public Inventory toEntity() {
        Inventory inventory = new Inventory();
        inventory.setCapacity(this.getCapacity());
        inventory.setItems(this.toEntity().getItems());
        return inventory;
    }

    public static List<InventoryDTO> fromEntity(List<Inventory> inventory) {
        return inventory.stream().map(InventoryDTO::fromEntity).collect(Collectors.toList());
    }

}
