package com.handbook.handbookapi.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService service;

    @GetMapping("{id}")
    public ResponseEntity findAllByAccountId(@PathVariable("id") Long id) {
        List<Character> character = service.findAllByAccountId(id);
        return ResponseEntity.ok(character);
    }
}