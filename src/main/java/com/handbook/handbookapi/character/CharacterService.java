package com.handbook.handbookapi.character;

import com.handbook.handbookapi.character.race.RaceType;
import com.handbook.handbookapi.common.AbilityType;
import com.handbook.handbookapi.common.AbstractService;
import com.handbook.handbookapi.exceptions.GameRuleException;
import com.mysema.commons.lang.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CharacterService extends AbstractService<Character, Long> {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    protected JpaRepository<Character, Long> getRepository() { return characterRepository; }

    public List<Character> findAllByUserId(Long id) {
        return characterRepository.findAll(QCharacter.character.user.id.eq(id));
    }

    @Override
    public Character save(Character character) {
        if (Objects.nonNull(character.getRace())) {
             addRaceAttributes(character);
        }

        character.setProficiency(2);

        //TODO Criar behaviour da classe para compreender a vida base do personagem
        // Por momento setaremos um valor fixo para indicar o lugar onde deve ficar na rotina

        character.setLife(15);
        character.setHitDice("1d8");

        validateAttributes(character);

        return super.save(character);
    }

    private static void validateAttributes(Character character) {
        boolean hasInvalidAttribute = character.getAllAttributes().stream().anyMatch(attribute -> {
            return attribute > 20 || attribute < 0;
        });

        if (hasInvalidAttribute) {
            throw new GameRuleException("Atributos não podem exceder o valor de 20 ou serem inferiores a 0");
        }
    }

    private void addRaceAttributes(Character character) {
        RaceType race = character.getRace().getRaceType();

        Pair<Integer, AbilityType> pairMainAttribute = race.getMainAttributeModifier();
        Pair<Integer, AbilityType> pairSecondaryAttribute = race.getSecondaryAttributeType();

        if(Objects.nonNull(pairMainAttribute)) {
            addPairAtributes(pairMainAttribute, character);
        }

        if(Objects.nonNull(pairSecondaryAttribute)) {
            addPairAtributes(pairSecondaryAttribute, character);
        }
    }

    private void addPairAtributes(Pair<Integer, AbilityType> attributeModifier, Character character) {
        switch (attributeModifier.getSecond()) {
            case WISDOM -> character.sumWisdom(attributeModifier.getFirst());
            case STRENGTH -> character.sumStrength(attributeModifier.getFirst());
            case DEXTERITY -> character.sumDexterity(attributeModifier.getFirst());
            case CONSTITUTION -> character.sumConstitution(attributeModifier.getFirst());
            case INTELLIGENCE -> character.sumIntelligence(attributeModifier.getFirst());
            case CHARISMA -> character.sumCharisma(attributeModifier.getFirst());
            case ALL -> character.sumAllAttributes(attributeModifier.getFirst());
        }
    }
}