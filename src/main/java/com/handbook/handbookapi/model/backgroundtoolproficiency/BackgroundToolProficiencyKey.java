package com.handbook.handbookapi.model.backgroundtoolproficiency;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BackgroundToolProficiencyKey {
    @Column(name = "background_id")
    private Long backgroundId;

    @Column(name = "tool_proficiency_id")
    private Long toolProficiencyId;
}
