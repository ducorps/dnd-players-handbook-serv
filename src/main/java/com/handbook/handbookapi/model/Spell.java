package com.handbook.handbookapi.model;

public class Spell {
    private String name;
    private Integer castingTime;
    private String description;
    private Double range;
    private Integer duration;
    private Component component;
    private String necessaryObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(Integer castingTime) {
        this.castingTime = castingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getNecessaryObject() {
        return necessaryObject;
    }

    public void setNecessaryObject(String necessaryObject) {
        this.necessaryObject = necessaryObject;
    }
}