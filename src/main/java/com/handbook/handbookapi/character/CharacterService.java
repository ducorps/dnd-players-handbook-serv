package com.handbook.handbookapi.character;

import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.background.BackgroundService;
import com.handbook.handbookapi.background.BackgroundType;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.CharacterClassFactory;
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

        Character characterSaved = save(character);

        inventoryService.createNewInventory(characterSaved);

        return characterSaved;
    }


    public Character step1(Character character) {
        if (Objects.nonNull(character.getRace())) {
            addRaceAttributes(character);
        }

        validateAttributes(character);

        character.setProficiency(2);

        return super.save(character);
    }
    public Character saveStep2(Character character) {
        CharacterClass characterClass = CharacterClassFactory.getCharacterClass(character.getClassType());

        Integer baseHealth = calculateBaseHealth(character, characterClass);

        character.setLife(baseHealth);

        return super.save(character);
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

    public Character updateBackground(Long idCharacter, BackgroundType backgroundType) {
        Character character = getById(idCharacter);

        Background newBackground = backgroundService.findByBackgroundType(backgroundType);
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