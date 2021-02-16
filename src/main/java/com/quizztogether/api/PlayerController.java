package com.quizztogether.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @GetMapping("/api/player/create/{name}")
    public Player createPlayer(@PathVariable String name)
    {
        return new Player(name);
    }
}
