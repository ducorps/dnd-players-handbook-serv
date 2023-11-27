package com.handbook.handbookapi.character.race;

import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RaceService extends AbstractService<Race, Long> {

    @Autowired
    private RaceRepository raceRepository;

    @Override
    protected JpaRepository<Race, Long> getRepository() {
        return raceRepository;
    }

    public Race findByRaceType(RaceType raceType) {
        return raceRepository.findByRaceType(raceType);
    }
}
