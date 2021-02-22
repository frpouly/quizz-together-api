package com.quizztogether.api.Models;

public class Player {
    private int id;
    private String name;
    private int points = 0;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Player(int id) {
        this.id = id;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass() != this.getClass())
            return false;
        Player p = (Player) o;
        return this.id == p.id;
    }
}
