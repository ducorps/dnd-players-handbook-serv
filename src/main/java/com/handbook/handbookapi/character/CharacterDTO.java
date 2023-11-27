package com.handbook.handbookapi.character;

import com.handbook.handbookapi.background.BackgroundDTO;
import com.handbook.handbookapi.character.characterclass.CharacterClassDTO;
import com.handbook.handbookapi.character.language.LanguageDTO;
import com.handbook.handbookapi.character.race.RaceDTO;
import com.handbook.handbookapi.character.race.RaceType;
import com.handbook.handbookapi.skill.Skill;
import com.handbook.handbookapi.skill.SkillDTO;
import com.handbook.handbookapi.spell.SpellDTO;
import com.handbook.handbookapi.user.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CharacterDTO {

    private String name;
    private BackgroundDTO background;
    private UserDTO user;
    private SkillDTO skill;
    private List<LanguageDTO> languages;
    private List<SpellDTO> spells;
    private RaceDTO race;
    private Integer experience;
    private Integer proficiency;
    private Integer armorClass;
    private Integer initiative;
    private Integer moveSpeed;
    private Integer life;
    private Integer temporaryLife;
    private String description;
    private CharacterClassDTO classType;
    private Integer level;
    private Integer intelligence;
    private Integer strength;
    private Integer constitution;
    private Integer wisdom;
    private Integer dexterity;
    private Integer charisma;

    public static CharacterDTO fromEntity(Character character) {
        CharacterDTO dto = new CharacterDTO();

        dto.setName(character.getName());
        dto.setBackground(BackgroundDTO.fromEntity(character.getBackground()));
        dto.setUser(UserDTO.fromEntity(character.getUser()));
        dto.setSkill(SkillDTO.fromEntity(character.getSkill()));
        dto.setLanguages(LanguageDTO.fromEntity(character.getLanguages()));
        dto.setSpells(SpellDTO.fromEntity(character.getSpells()));
        dto.setRace(RaceDTO.fromEntity(character.getRace()));
        dto.setExperience(character.getExperience());
        dto.setProficiency(character.getProficiency());
        dto.setArmorClass(character.getArmorClass());
        dto.setInitiative(character.getInitiative());
        dto.setMoveSpeed(character.getMoveSpeed());
        dto.setLife(character.getLife());
        dto.setTemporaryLife(character.getTemporaryLife());
        dto.setDescription(character.getDescription());
        dto.setClassType(CharacterClassDTO.fromEntity(character.getCharacterClass()));
        dto.setLevel(character.getLevel());
        dto.setIntelligence(character.getIntelligence());
        dto.setStrength(character.getStrength());
        dto.setConstitution(character.getConstitution());
        dto.setWisdom(character.getWisdom());
        dto.setDexterity(character.getDexterity());
        dto.setCharisma(character.getCharisma());

        return dto;
    }

    public Character toEntity() {
        Character character = new Character();

        character.setName(character.getName());
        character.setBackground(this.getBackground().toEntity());
        character.setUser(this.getUser().toEntity());
        character.setSkill(this.getSkill().toEntity());
        character.setLanguages(this.getLanguages().stream().map(LanguageDTO::toEntity).collect(Collectors.toList()));
        character.setSpells(this.getSpells().stream().map(SpellDTO::toEntity).collect(Collectors.toList()));
        character.setRace(this.getRace().toEntity());
        character.setExperience(character.getExperience());
        character.setProficiency(character.getProficiency());
        character.setArmorClass(character.getArmorClass());
        character.setInitiative(character.getInitiative());
        character.setMoveSpeed(character.getMoveSpeed());
        character.setLife(character.getLife());
        character.setTemporaryLife(character.getTemporaryLife());
        character.setDescription(character.getDescription());
        character.setCharacterClass(this.getCharacterClass().toEntity());
        character.setLevel(character.getLevel());
        character.setIntelligence(character.getIntelligence());
        character.setStrength(character.getStrength());
        character.setConstitution(character.getConstitution());
        character.setWisdom(character.getWisdom());
        character.setDexterity(character.getDexterity());
        character.setCharisma(character.getCharisma());

        return character;
    }

    public static Page<CharacterDTO> fromEntity(Page<Character> characters) {
        List<CharacterDTO> charactersFind = characters.stream().map(character -> fromEntity(character)).collect(Collectors.toList());
        Page<CharacterDTO> charactersDTO = new PageImpl<>(charactersFind, characters.getPageable(), characters.getTotalElements());
        return charactersDTO;
    }
}
