package com.quizztogether.api.controllers;

import com.quizztogether.api.Models.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/game")
public class GameController {

    final
    GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    @GetMapping("/create")
    public Game createGame() {
        return model.createGame();
    }

    @GetMapping("/{id}/add_player/{name}")
    @ResponseBody
    public Player createPlayer(@PathVariable String id, @PathVariable String name, HttpServletRequest request, HttpServletResponse response) {
        Player ret = model.addAPlayer(id, name);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }

    @GetMapping("/{idGame}/new_round")
    @ResponseBody
    public Question newRound(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) throws ExecutionException, InterruptedException {
        Question ret = model.newRound(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }

    @GetMapping("/{idGame}/end_round")
    @ResponseBody
    public List<Player> endRound(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) {
        List<Player> ret = model.endRound(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }

    @GetMapping("/{idGame}/{idPlayer}/{answer}")
    public boolean makeAnswer(@PathVariable String idGame, @PathVariable int idPlayer, @PathVariable int answer) {
        return model.answer(idPlayer, idGame, answer);
    }

    @GetMapping("/{idGame}/end_game")
    public Game endGame(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) {
        Game ret = model.endGame(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
}
