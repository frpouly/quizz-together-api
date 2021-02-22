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
        Game g = applicationContext.getBean(Game.class);
        dictionaryGames.put(g.getGameId(), g);
        return g;
    }

    public Player addAPlayer(String id, String name) {
        if(dictionaryGames.containsKey(id)) {
            Player p = dictionaryGames.get(id).addPlayer(name);
            return p;
        }
        return null;
    }

    public boolean answer(Integer p, String idGame, int answer) {
        return dictionaryGames.get(idGame).answer(p, answer);
    }

    public Question newRound(String idGame) throws ExecutionException, InterruptedException {
        return dictionaryGames.get(idGame).newRound();
    }

    public List<Player> endRound(String idGame) {
        return dictionaryGames.get(idGame).endRound();
    }
}
