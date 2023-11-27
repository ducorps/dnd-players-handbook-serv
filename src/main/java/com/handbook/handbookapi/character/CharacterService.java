package com.handbook.handbookapi.character;

import com.handbook.handbookapi.character.characterclass.CharacterClassService;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.background.BackgroundService;
import com.handbook.handbookapi.background.BackgroundType;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.CharacterClassFactory;
import com.handbook.handbookapi.character.race.Race;
import com.handbook.handbookapi.character.race.RaceService;
import com.handbook.handbookapi.character.race.RaceType;
import com.handbook.handbookapi.common.AbilityType;
import com.handbook.handbookapi.common.AbstractService;
import com.handbook.handbookapi.exceptions.GameRuleException;
import com.handbook.handbookapi.inventory.InventoryService;
import com.handbook.handbookapi.skill.Skill;
import com.handbook.handbookapi.user.User;
import com.handbook.handbookapi.user.UserDetailsImpl;
import com.handbook.handbookapi.utils.ModifierUtils;
import com.mysema.commons.lang.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

@Service
public class CharacterService extends AbstractService<Character, Long> {

    @Autowired
    private CharacterRepository characterRepository;

    private BackgroundService backgroundService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CharacterClassService characterClassService;

    @Autowired
    private RaceService raceService;

    @Override
    protected JpaRepository<Character, Long> getRepository() { return characterRepository; }

    public Page<Character> findAllByUserId(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return characterRepository.findAllWithPredicate(QCharacter.character.user.id.eq(userDetails.getId()), pageable);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character createCharacter() {
        Character character = new Character();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        User user = new User();

        user.setId(userDetails.getId());

        character.setUser(user);
        character.setAllAttributes(0);

        Character characterSaved = save(character);

        inventoryService.createNewInventory(characterSaved);

        return characterSaved;
    }


    public Character updateCharacterRace(Long idCharacter, Race race) {
        Character character = getById(idCharacter);
        Race raceSaved = raceService.findByRaceType(race.getRaceType());

        if (Objects.isNull(raceSaved)) {
            throw new GameRuleException("Race not found");
        }
        character.setRace(raceSaved);
        addRaceAttributes(character);

        validateAttributes(character);

        character.setProficiency(2);

        return super.save(character);
    }

    public Character updateCharacterClass(Long idCharacter, CharacterClass characterClass) {
        Character character = getById(idCharacter);
        CharacterClass characterClassSaved = characterClassService.findByClassType(characterClass.getClassType());
        CharacterClass characterClassBuilt = CharacterClassFactory.getCharacterClass(characterClassSaved);

        characterClassBuilt.setId(characterClassSaved.getId());
        characterClassBuilt.setClassType(characterClassSaved.getClassType());

        character.setCharacterClass(characterClassBuilt);

        Integer baseHealth = calculateBaseHealth(character, characterClassBuilt);

        character.setHitDie(characterClassBuilt.getHitDie().toString());
        character.setLife(baseHealth);

        return save(character);
    }

    private static int calculateBaseHealth(Character character, CharacterClass characterClass) {
        return characterClass.getHitDie().roll() + ModifierUtils.getModifier(character.getConstitution());
    }

    private static void validateAttributes(Character character) {
        boolean hasInvalidAttribute = character.getAllAttributes().stream().anyMatch(attribute -> attribute > 20 || attribute < 0);

        if (hasInvalidAttribute) {
            throw new GameRuleException("Skills cannot be higher than 20 nor be lower than 0");
        }
    }

    private void addRaceAttributes(Character character) {
        Race race = character.getRace();

        Pair<Integer, AbilityType> pairMainAttribute = race.getRaceType().getMainAttributeModifier();
        Pair<Integer, AbilityType> pairSecondaryAttribute = race.getRaceType().getSecondaryAttributeType();

        if(Objects.nonNull(pairMainAttribute.getFirst())) {
            addPairAtributes(pairMainAttribute, character);
        }

        if(Objects.nonNull(pairSecondaryAttribute.getFirst())) {
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

    public Character updateBackground(Long idCharacter, Background background) {
        Character character = getById(idCharacter);

        Background newBackground = backgroundService.findByBackgroundType(background.getBackgroundType());
        character.setBackground(newBackground);

        return save(character);
    }

    public Character addSkills(Long idCharacter, List<String> listSkills) {
        Character character = getById(idCharacter);
        Skill skill = character.getSkill();

        listSkills.forEach(skillName -> {
            try {
                Field field = skill.getClass().getDeclaredField(skillName);
                field.setAccessible(true);

                Integer fieldValue = field.getInt(skill);
                field.setInt(skill, fieldValue + character.getProficiency());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new GameRuleException("Não foi possível adicionar a skill " + skillName);
            }
        });

        return save(character);
    }

    public Character addLanguages(Long idCharacter, List<Language> languages) {
        Character character = characterRepository.findById(idCharacter).orElse(null);

        if(Objects.nonNull(languages)) {
            character.setLanguages(languages);
        }
        return save(character);
    }
}