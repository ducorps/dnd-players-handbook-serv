package com.handbook.handbookapi.background;

import com.handbook.handbookapi.background.skillproficiency.SkillProficiencyDTO;
import com.handbook.handbookapi.background.toolproficiency.ToolProficiencyDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class BackgroundDTO {

    private BackgroundType backgroundType;
    private Integer extraLanguages;
    private List<SkillProficiencyDTO> skillProficiencies;
    private List<ToolProficiencyDTO> toolProficiencies;

    public static BackgroundDTO fromEntity(Background background) {
        if (Objects.isNull(background)) {
            return null;
        }

        BackgroundDTO dto = new BackgroundDTO();

        dto.setBackgroundType(background.getBackgroundType());
        dto.setExtraLanguages(background.getExtraLanguages());
        dto.setToolProficiencies(ToolProficiencyDTO.fromEntity(background.getToolProficiencies()));
        dto.setSkillProficiencies(SkillProficiencyDTO.fromEntity(background.getSkillProficiencies()));

        return dto;
    }

    public Background toEntity() {
        Background background = new Background();
        background.setBackgroundType(this.getBackgroundType());
        background.setExtraLanguages(this.getExtraLanguages());

        return background;
    }

}
