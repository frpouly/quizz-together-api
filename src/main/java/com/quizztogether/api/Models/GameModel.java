package com.quizztogether.api.Models;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class GameModel {

    private static HashMap<String, Game> dictionaryGames = new HashMap<>();

    private final ApplicationContext applicationContext;

    public GameModel(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Game createGame() {
        Game g = new Game(applicationContext);
        dictionaryGames.put(g.getGameId(), g);
        return g;
    }

    public Player addAPlayer(String id, String name) {
        if(dictionaryGames.containsKey(id))
            return dictionaryGames.get(id).addPlayer(name);
        return null;
    }

    public boolean answer(Integer p, String idGame, int answer) {
        return dictionaryGames.get(idGame).answer(p, answer);
    }

    public Question newRound(String idGame) throws ExecutionException, InterruptedException {
        return dictionaryGames.containsKey(idGame) ? dictionaryGames.get(idGame).newRound() : null;
    }

    public Round endRound(String idGame) {
        return dictionaryGames.containsKey(idGame) ? dictionaryGames.get(idGame).endRound() : null;
    }

    public Game endGame(String idGame) {
        return dictionaryGames.containsKey(idGame) ? dictionaryGames.remove(idGame) : null;
    }

    public Game getGame(String idGame) {
        return dictionaryGames.get(idGame);
    }

    public Player getPlayer(String idGame, int idPlayer) {
        return dictionaryGames.get(idGame).getPlayers().get(idPlayer);
    }
}
