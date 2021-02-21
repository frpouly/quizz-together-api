package com.quizztogether.api;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GameModel {

    private final int ID_LENGTH = 6;

    private static HashMap<String, Game> dictionaryGames = new HashMap<>();

    public Game createGame() {
        String id = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
        Game g = new Game(id);
        dictionaryGames.put(id, g);
        return g;
    }

    public boolean addAPlayer(String id, Player p) {
        if(dictionaryGames.containsKey(id)) {
            dictionaryGames.get(id).addPlayer(p);
            return true;
        }
        return false;
    }
}
