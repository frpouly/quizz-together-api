package com.quizztogether.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final int ID_LENGTH = 6;

    @GetMapping("/api/game/create")
    public String getAllQuestions() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
}
