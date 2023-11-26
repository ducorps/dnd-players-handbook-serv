package com.handbook.handbookapi.character.race;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceDTO {
    private RaceType raceType;

    public static RaceDTO fromEntity(Race race) {
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
