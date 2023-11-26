package com.handbook.handbookapi.character;

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

    @GetMapping("/{id}")
    public ResponseEntity findAllByUserId(@PathVariable("id") Long id) {
        List<Character> character = characterService.findAllByUserId(id);
        return ResponseEntity.ok(character);
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
}
