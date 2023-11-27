package com.handbook.handbookapi.character.race;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class RaceDTO {
    private RaceType raceType;

    public static RaceDTO fromEntity(Race race) {
        if (Objects.isNull(race)) {
            return null;
        }

        RaceDTO dto = new RaceDTO();
        dto.setRaceType(race.getRaceType());

        return dto;
    }

    public Race toEntity() {
        Race race = new Race();
        race.setRaceType(this.getRaceType());

        return race;
    }
}
