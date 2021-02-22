package com.quizztogether.api.controllers;

import com.quizztogether.api.Models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.List;

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
    public Player createPlayer(@PathVariable String id, @PathVariable String name) {
        return model.addAPlayer(id, name);
    }

    @GetMapping("/api/game/{idGame}/new_round")
    public Question newRound(@PathVariable String idGame) throws ExecutionException, InterruptedException {
        return model.newRound(idGame);
    }

    @GetMapping("/api/game/{idGame}/end_round")
    public List<Player> endRound(@PathVariable String idGame) {
        return model.endRound(idGame);
    }

    @GetMapping("/api/game/{idGame}/{idPlayer}/{answer}")
    public boolean makeAnswer(@PathVariable String idGame, @PathVariable int idPlayer, @PathVariable int answer) {
        return model.answer(idPlayer, idGame, answer);
    }
}
