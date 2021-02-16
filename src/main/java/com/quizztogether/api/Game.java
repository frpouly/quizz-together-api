package com.quizztogether.api;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private String game_id;
    private List<Player> players = new ArrayList<>();

    public Game(String id) {
        game_id = id;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getGame_id() {
        return game_id;
    }
}
