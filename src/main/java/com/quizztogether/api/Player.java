package com.quizztogether.api;

import java.util.HashMap;
import java.util.UUID;

public class Player {
    private String id;
    private String name;

    private static HashMap<String, Player> dictionaryPlayers = new HashMap<>();

    public Player(String name)
    {
        this.name = name;
        id = UUID.randomUUID().toString();
        dictionaryPlayers.put(id, this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
