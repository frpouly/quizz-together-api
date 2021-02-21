package com.quizztogether.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    final
    GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    @GetMapping("/api/game/create")
    public Game getAllQuestions() {
        return model.createGame();
    }

    @GetMapping("/api/game/{id}/add_player/{name}")
    public boolean createPlayer(@PathVariable String id, @PathVariable String name) {
        return model.addAPlayer(id, new Player(name));
    }

    @GetMapping("/api/game/{idGame}/{idPlayer}/{answer}")
    public void makeAnswer(@PathVariable String idGame, @PathVariable String idPlayer, @PathVariable String answer) {
        
    }
}
