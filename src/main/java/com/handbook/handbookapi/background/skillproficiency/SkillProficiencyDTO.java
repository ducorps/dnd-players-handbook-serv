package com.handbook.handbookapi.background.skillproficiency;

import com.handbook.handbookapi.background.toolproficiency.ToolProficiency;
import com.handbook.handbookapi.background.toolproficiency.ToolProficiencyDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.util.List;
@Getter
@Setter
public class SkillProficiencyDTO {

    private SkillProficiencyType skillProficiencyType;

    public static SkillProficiencyDTO fromEntity(SkillProficiency skillProficiency) {
        SkillProficiencyDTO dto = new SkillProficiencyDTO();
        dto.setSkillProficiencyType(skillProficiency.getSkillProficiencyType());

        return dto;
    };

    public SkillProficiency toEntity() {
        SkillProficiency skillProficiency = new SkillProficiency();
        skillProficiency.setSkillProficiencyType(this.getSkillProficiencyType());

        return skillProficiency;
    };

    public static List<SkillProficiencyDTO> fromEntity(List<SkillProficiency> skillProficiencies) {
        return skillProficiencies.stream().map(SkillProficiencyDTO::fromEntity).collect(Collectors.toList());
    }
}
