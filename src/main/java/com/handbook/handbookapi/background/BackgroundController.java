package com.handbook.handbookapi.background;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backgrounds")
public class BackgroundController {

    private BackgroundService backgroundService;

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Background background = backgroundService.findById(id);

        return ResponseEntity.ok(background);
    }
}
