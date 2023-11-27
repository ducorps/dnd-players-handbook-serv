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
    public ResponseEntity findAll() {
        List<Character> characters = characterService.findAll();
        return ResponseEntity.ok(characters);
    }

    @GetMapping("/user")
    public ResponseEntity findAllByUserId(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        Page<Character> characters = characterService.findAllByUserId(PageRequest.of(page, size));
        Page<CharacterDTO> characterDTOS = CharacterDTO.fromEntity(characters);
        return ResponseEntity.ok(characterDTOS);
    }

    @GetMapping("/{idCharacter}")
    public ResponseEntity findByCharacterId(@PathVariable("idCharacter") Long idCharacter) {
        Character character = characterService.getById(idCharacter);

        return ResponseEntity.ok(character);
    }

    @PostMapping("/new-character")
    public ResponseEntity<Character> create() {
        Character saved = characterService.createCharacter();

        return ResponseEntity.ok(saved);
    }

    @PostMapping("{idCharacter}/race")
    public ResponseEntity<Character> updateCharacterRace(@PathVariable("idCharacter") Long idCharacter, @RequestBody Race race) {
        Character saved = characterService.updateCharacterRace(idCharacter, race);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/class")
    public ResponseEntity<Character> updateCharacterClass(@PathVariable("idCharacter") Long idCharacter, @RequestBody CharacterClass characterClass) {
        Character saved = characterService.updateCharacterClass(idCharacter, characterClass);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/background")
    public ResponseEntity updateCharacterBackground(@PathVariable("idCharacter") Long idCharacter, @RequestBody Background background) {
        Character saved = characterService.updateBackground(idCharacter, background);

        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/language")
    public ResponseEntity<Character> updateLanguages(@PathVariable("idCharacter") Long idCharacter, @RequestBody List<Language> languages){
       Character saved = characterService.updateLanguages(idCharacter, languages);

       return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/skill")
    public ResponseEntity<Character> updateSkills(@PathVariable("idCharacter") Long idCharacter, @RequestBody List<String> skills){
        Character saved = characterService.updateSkills(idCharacter, skills);

        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/final-step")
    public ResponseEntity updateFinalStep(@PathVariable("idCharacter") Long idCharacter,  @RequestBody FinalStepDTO finalStepDTO) {
        Character saved = characterService.updateFinalStep(idCharacter, finalStepDTO);

        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("{idCharacter}")
    public ResponseEntity delete(@PathVariable("idCharacter") Long idCharacter) {
        characterService.deleteCharacter(idCharacter);

        return ResponseEntity.ok().build();
    }
}
