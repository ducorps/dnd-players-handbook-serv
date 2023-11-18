package com.handbook.handbookapi.character;

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

    @GetMapping("/{id}")
    public ResponseEntity findAllByUserId(@PathVariable("id") Long id) {
        List<Character> character = characterService.findAllByUserId(id);
        return ResponseEntity.ok(character);
    }

    @PostMapping
    public ResponseEntity<Character> create(@RequestBody Character character) {
        Character saved = characterService.save(character);
        return ResponseEntity.created(URI.create("/characters/" + saved.getId())).body(saved);
    }
}
