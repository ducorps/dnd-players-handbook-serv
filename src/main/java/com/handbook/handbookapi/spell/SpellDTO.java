package com.handbook.handbookapi.spell;

import com.handbook.handbookapi.spell.component.Component;
import com.handbook.handbookapi.spell.component.ComponentDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class SpellDTO {

    private String name;
    private Integer castingTime;
    private String description;
    private Double range;
    private Integer duration;
    private String necessaryObject;
    private List<ComponentDTO> components;

    public static SpellDTO fromEntity(Spell spell) {
        if (Objects.isNull(spell)) {
            return null;
        }

        SpellDTO dto = new SpellDTO();
        dto.setName(spell.getName());
        dto.setCastingTime(spell.getCastingTime());
        dto.setDescription(spell.getDescription());
        dto.setRange(spell.getRange());
        dto.setDuration(spell.getDuration());
        dto.setNecessaryObject(spell.getNecessaryObject());
        dto.setComponents(ComponentDTO.fromEntity(spell.getComponents()));

        return dto;
    }

    public Spell toEntity() {
        Spell spell = new Spell();
        spell.setName(this.getName());
        spell.setCastingTime(this.getCastingTime());
        spell.setDescription(this.getDescription());
        spell.setRange(this.getRange());
        spell.setDuration(this.getDuration());
        spell.setNecessaryObject(this.getNecessaryObject());
        spell.setComponents(this.toEntity().getComponents());

        return spell;
    }

    public static List<SpellDTO> fromEntity(List<Spell> spell) {
        if(Objects.isNull(spell)) {
            return null;
        }
        return spell.stream().map(SpellDTO::fromEntity).collect(Collectors.toList());
    }

}
