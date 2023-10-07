package com.handbook.handbookapi.model.background;

import com.handbook.handbookapi.model.ToolProficiency;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BackgroudToolProficiencyKey {

    @Column(name = "background_id")
    private Long backgroundId;

    @Column(name = "tool_proficiency_id")
    private Long toolProficiencyId;
}
