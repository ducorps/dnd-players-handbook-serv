package com.handbook.handbookapi.model.background;

import com.handbook.handbookapi.model.ToolProficiency;
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
    private BackgroudToolProficiencyKey id;

    @ManyToOne
    @MapsId("backgroundId")
    @JoinColumn(name = "background_id")
    private Background background;

    @ManyToOne
    @MapsId("toolProficiencyId")
    @JoinColumn(name = "tool_proficiency_id")
    private ToolProficiency toolProficiency;
}
