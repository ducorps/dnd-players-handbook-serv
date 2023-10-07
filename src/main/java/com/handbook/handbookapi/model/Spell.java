package com.handbook.handbookapi.model;

import javax.persistence.*;

@Entity
public class Spell extends EntityId{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "casting_time", nullable = false)
    private Integer castingTime;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "range", nullable = false)
    private Double range;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "component", nullable = false)
    private Component component;

    @Column(name = "necessary_objects")
    private String necessaryObject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "spell_component",
            joinColumns = @JoinColumn(name = "spell_id"),
            inverseJoinColumns = @JoinColumn(name = "component_id")
    )

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
