package com.handbook.handbookapi.character;

import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.background.BackgroundType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity findAllByUserId() {
        List<Character> character = characterService.findAllByUserId();
        return ResponseEntity.ok(character);
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
    public ResponseEntity<Character> saveRace(@RequestBody Character character) {
        Character saved = characterService.save(character);
        return ResponseEntity.created(URI.create("/characters/" + saved.getId())).body(saved);
    }

    @PostMapping("/{idCharacter}/background")
    public ResponseEntity saveBackgroundByType(@PathVariable("idCharacter") Long idCharacter, @RequestBody BackgroundType backgroundType) {
        Character character = characterService.updateBackground(idCharacter, backgroundType);

        return ResponseEntity.ok(character);
    }

    @PostMapping("/{idCharacter}/language")
    public ResponseEntity<Character> addLanguages(@PathVariable("idCharacter") Long idCharacter, @RequestBody List<Language> languages){
       Character saved = characterService.addLanguages(idCharacter, languages);

       return ResponseEntity.ok(saved);
    }
}
