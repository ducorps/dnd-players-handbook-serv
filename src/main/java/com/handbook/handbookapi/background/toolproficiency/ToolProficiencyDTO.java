package com.handbook.handbookapi.background.toolproficiency;

import lombok.Getter;
import lombok.Setter;
import java.util.stream.Collectors;
import java.util.List;

@Getter
@Setter
public class ToolProficiencyDTO {

    private ToolProficiencyType toolProficiencyType;

    public static ToolProficiencyDTO fromEntity(ToolProficiency toolProficiency) {
        ToolProficiencyDTO dto = new ToolProficiencyDTO();
        dto.setToolProficiencyType(toolProficiency.getToolProficiencyType());

        return dto;
    };

    public ToolProficiency toEntity() {
        ToolProficiency toolProficiency = new ToolProficiency();
        toolProficiency.setToolProficiencyType(this.getToolProficiencyType());

        return toolProficiency;
    };

    public static List<ToolProficiencyDTO> fromEntity(List<ToolProficiency> toolProficiencies) {
        return toolProficiencies.stream().map(ToolProficiencyDTO::fromEntity).collect(Collectors.toList());
    }
}
