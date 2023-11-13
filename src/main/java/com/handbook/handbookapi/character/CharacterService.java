package com.handbook.handbookapi.character;

import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService extends AbstractService<Character, Long> {
    @Autowired
    private CharacterRepository repository;

    @Override
    protected JpaRepository<Character, Long> getRepository() { return repository; }

    public List<Character> findAllByAccountId(Long id) {
        return repository.findAll(QCharacter.character.user.id.eq(id));
    }
}
