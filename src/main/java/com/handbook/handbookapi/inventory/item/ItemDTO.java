package com.handbook.handbookapi.inventory.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.value.Value;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
@Setter
public class ItemDTO {

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Value value;
    private String name;
    private Integer weight;
    private String type;
    private Integer strength;
    private Boolean stealth;
    private Integer armorClass;
    private ArmorType armorType;
    private String damage;
    private List<WeaponProperties> properties;

    public Item toEntity() {
        return switch (type) {
            case "WEAPON" -> new Weapon(this.getDamage(), this.getProperties());
            case "ARMOR" -> new Armor(this.getName(), this.getWeight(), this.getValue(), this.getStrength(),
                    this.getStealth(), this.getArmorClass(), this.getArmorType());
            default -> new Item(this.getName(), this.getWeight(), this.getValue());
        };
    }

    public static ItemDTO fromEntity(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(item.getName());
        itemDTO.setWeight(item.getWeight());

        if(item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            itemDTO.setDamage(weapon.getDamage());
            itemDTO.setProperties(weapon.getProperties());
            itemDTO.setType("WEAPON");
        }

        if(item instanceof Armor) {
            Armor armor = (Armor) item;
            itemDTO.setStrength(armor.getStrength());
            itemDTO.setStealth(armor.getStealth());
            itemDTO.setArmorClass(armor.getArmorClass());
            itemDTO.setArmorType(armor.getArmorType());
            itemDTO.setType("ARMOR");
        }

        return itemDTO;
    }

    public static ItemDTO fromApi(LinkedHashMap<?, ?> json) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName((String) json.get("name"));
        itemDTO.setWeight((Integer) json.get("weight"));

        if(json.get("strength") != null) {
            itemDTO.setStrength((Integer) json.get("strength"));
            itemDTO.setStealth((Boolean) json.get("stealth_disadvantage"));
            itemDTO.setArmorClass((Integer) json.get("armor_class"));
            itemDTO.setArmorType(ArmorType.valueOf((String) json.get("armor_category")));
            itemDTO.setType("ARMOR");
        }

        if(json.get("damage") != null) {
            itemDTO.setDamage((String) ((LinkedHashMap<?, ?>) json.get("damage")).get("damage_dice"));
            itemDTO.setProperties(
                    ((ArrayList<LinkedHashMap<?, ?>>) json.get("properties"))
                            .stream()
                            .map(property -> {
                                WeaponProperties weaponProperties = new WeaponProperties();
                                weaponProperties.setName((String) property.get("name"));
                                return weaponProperties;
                            })
                            .toList());
            itemDTO.setType("WEAPON");
        }

        return itemDTO;
    }

    public static List<ItemDTO> fromEntity(List<Item> items) {
        return items.stream().map(ItemDTO::fromEntity).toList();
    }

    public static Page<ItemDTO> fromEntity(Page<Item> items) {
        return items.map(ItemDTO::fromEntity);
    }
}
