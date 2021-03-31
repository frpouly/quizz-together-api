package com.quizztogether.api.controllers;

import com.quizztogether.api.Models.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;
import java.util.List;

@RestController
public class GameController {

    final
    GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }
    @CrossOrigin
    @PostMapping("/api/game/create")
    public Game createGame() {
        return model.createGame();
    }
    @CrossOrigin
    @PostMapping("/api/game/{id}/add_player/{name}")
    @ResponseBody
    public Player createPlayer(@PathVariable String id, @PathVariable String name, HttpServletRequest request, HttpServletResponse response) {
        Player ret = model.addAPlayer(id, name);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
    @CrossOrigin
    @PostMapping("/api/game/{idGame}/new_round")
    @ResponseBody
    public Question newRound(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) throws ExecutionException, InterruptedException {
        Question ret = model.newRound(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
    @CrossOrigin
    @PutMapping("/api/game/{idGame}/end_round")
    @ResponseBody
    public Round endRound(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) {
        Round ret = model.endRound(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
    @CrossOrigin
    @PutMapping("/api/game/{idGame}/{idPlayer}/{answer}")
    public boolean makeAnswer(@PathVariable String idGame, @PathVariable int idPlayer, @PathVariable int answer) {
        return model.answer(idPlayer, idGame, answer);
    }
    @CrossOrigin
    @DeleteMapping("/api/game/{idGame}/end_game")
    public Game endGame(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) {
        Game ret = model.endGame(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
    @CrossOrigin
    @GetMapping("/api/game/{idGame}")
    public Game getGame(@PathVariable String idGame, HttpServletRequest request, HttpServletResponse response) {
        Game ret = model.getGame(idGame);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
    @CrossOrigin
    @GetMapping("/api/game/{idGame}/{idPlayer}")
    public Player getPlayer(@PathVariable String idGame, @PathVariable Integer idPlayer, HttpServletRequest request, HttpServletResponse response) {
        Player ret = model.getPlayer(idGame, idPlayer);
        if(ret == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ret;
    }
}
