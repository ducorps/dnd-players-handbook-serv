package com.handbook.handbookapi.model.backgroundtoolproficiency;

import com.handbook.handbookapi.model.toolproficiency.ToolProficiency;
import com.handbook.handbookapi.model.background.Background;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "background_tool_proficiency")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BackgroundToolProficiency {
    @EmbeddedId
    private BackgroundToolProficiencyKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("backgroundId")
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("toolProficiencyId")
    @JoinColumn(name = "tool_proficiency_id")
    private ToolProficiency toolProficiency;
}
