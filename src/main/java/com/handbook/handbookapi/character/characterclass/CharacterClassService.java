package com.handbook.handbookapi.character.characterclass;

import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterClassService extends AbstractService<CharacterClass, Long> {
    @Autowired
    private CharacterClassRepository characterClassRepository;

    @Override
    protected JpaRepository<CharacterClass, Long> getRepository() {
        return characterClassRepository;
    }

    public CharacterClass findByClassType(ClassType classType) {
        return characterClassRepository.findByClassType(classType);
    }
}
