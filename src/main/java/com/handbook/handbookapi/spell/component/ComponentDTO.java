package com.handbook.handbookapi.spell.component;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ComponentDTO {
    private ComponentType componentType;

    public static ComponentDTO fromEntity(Component component) {
        ComponentDTO dto = new ComponentDTO();
        dto.setComponentType(component.getComponentType());

        return dto;
    }

    public Component toEntity() {
        Component component = new Component();
        component.setComponentType(this.getComponentType());

        return component;
    }

    public static List<ComponentDTO> fromEntity(List<Component> component) {
        return component.stream().map(ComponentDTO::fromEntity).collect(Collectors.toList());
    }
}
