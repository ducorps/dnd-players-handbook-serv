package com.handbook.handbookapi.model;

import java.util.List;

public class Inventory {
    private Character character;
    private List<Equipment> equipment;
    private Double availableWeight;

    public Double getAvailableWeight() { return availableWeight; }

    public void setAvailableWeight(Double availableWeight) { this.availableWeight = availableWeight; }

    public List<Equipment> getEquipment() { return equipment; }

    public void setEquipment(List<Equipment> equipment) { this.equipment = equipment; }
}
