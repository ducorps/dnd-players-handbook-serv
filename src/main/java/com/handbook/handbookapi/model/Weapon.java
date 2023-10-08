package com.handbook.handbookapi.model;

public class Weapon extends Equipment {
    private Double damage;
    private String properties;

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
