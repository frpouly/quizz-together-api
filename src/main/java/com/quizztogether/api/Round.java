package com.quizztogether.api;

import java.util.HashMap;
import java.util.List;

public class Round {
    private Question question;
    private HashMap<Question, List<Player>> answers = new HashMap<>();

    public Round() {

    }
}
