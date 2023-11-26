package com.handbook.handbookapi.inventory.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.value.Value;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
public class ItemDTO {

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Value value;
    private String name;
    private Double weight;
    private String type;
    private Integer strength;
    private Boolean stealth;
    private Integer armorClass;
    private ArmorType armorType;
    private String damage;
    private String properties;
}
