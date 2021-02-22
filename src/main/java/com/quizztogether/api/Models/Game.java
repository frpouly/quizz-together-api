package com.quizztogether.api.Models;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class Game {
    private String gameId;
    private List<Player> players = new ArrayList<>();
    private Round currentRound = null;

    private final int ID_LENGTH = 6;

    private final ApplicationContext applicationContext;

    public Game(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        gameId = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }

    public Player addPlayer(String name) {
        Player p = new Player(name, players.size());
        players.add(p);
        return p;
    }

    public boolean answer(Integer p, int a) {
        if(currentRound == null)
            return false;
        return currentRound.addAnswer(p, a);
    }

    public List<Player> endRound() {
        if(currentRound == null)
            return null;
        List<Integer> winners = currentRound.getWinners();
        for(Integer p : winners) {
            players.get(p).addPoints(100);
        }
        return players;
    }

    public Question newRound() throws ExecutionException, InterruptedException {
        currentRound = applicationContext.getBean(Round.class);
        return currentRound.getQuestion();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getGameId() {
        return gameId;
    }
}
