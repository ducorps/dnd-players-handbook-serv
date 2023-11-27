package com.handbook.handbookapi.character;

import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.character.race.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> findAll() {
        List<Character> characters = characterService.findAll();
        List<CharacterDTO> characterDTOS = CharacterDTO.fromEntity(characters);
        return ResponseEntity.ok(characterDTOS);
    }

    @GetMapping("/user")
    public ResponseEntity findAllByUserId(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        Page<Character> characters = characterService.findAllByUserId(PageRequest.of(page, size));
        Page<CharacterDTO> characterDTOS = CharacterDTO.fromEntity(characters);
        return ResponseEntity.ok(characterDTOS);
    }

    @GetMapping("/{idCharacter}")
    public ResponseEntity<CharacterDTO> findByCharacterId(@PathVariable("idCharacter") Long idCharacter) {
        Character saved = characterService.getById(idCharacter);
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);

        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/new-character")
    public ResponseEntity<CharacterDTO> create() {
        Character saved = characterService.createCharacter();
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);

        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("{idCharacter}/race")
    public ResponseEntity<CharacterDTO> updateCharacterRace(@PathVariable("idCharacter") Long idCharacter, @RequestBody Race race) {
        Character saved = characterService.updateCharacterRace(idCharacter, race);
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);
        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/{idCharacter}/class")
    public ResponseEntity<CharacterDTO> updateCharacterClass(@PathVariable("idCharacter") Long idCharacter, @RequestBody CharacterClass characterClass) {
        Character saved = characterService.updateCharacterClass(idCharacter, characterClass);
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);
        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/{idCharacter}/background")
    public ResponseEntity<CharacterDTO> updateCharacterBackground(@PathVariable("idCharacter") Long idCharacter, @RequestBody Background background) {
        Character saved = characterService.updateBackground(idCharacter, background);
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);

        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/{idCharacter}/language")
    public ResponseEntity<CharacterDTO> updateLanguages(@PathVariable("idCharacter") Long idCharacter, @RequestBody List<Language> languages){
       Character saved = characterService.updateLanguages(idCharacter, languages);
       CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);

       return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/{idCharacter}/skill")
    public ResponseEntity<CharacterDTO> updateSkills(@PathVariable("idCharacter") Long idCharacter, @RequestBody List<String> skills){
        Character saved = characterService.updateSkills(idCharacter, skills);
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);

        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/{idCharacter}/final-step")
    public ResponseEntity<CharacterDTO> updateFinalStep(@PathVariable("idCharacter") Long idCharacter,  @RequestBody FinalStepDTO finalStepDTO) {
        Character saved = characterService.updateFinalStep(idCharacter, finalStepDTO);
        CharacterDTO characterDTO = CharacterDTO.fromEntity(saved);

        return ResponseEntity.ok(characterDTO);
    }

    @DeleteMapping("{idCharacter}")
    public ResponseEntity delete(@PathVariable("idCharacter") Long idCharacter) {
        characterService.deleteCharacter(idCharacter);

        return ResponseEntity.ok().build();
    }
}
