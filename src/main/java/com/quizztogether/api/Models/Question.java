package com.quizztogether.api.Models;

import java.util.List;

public class Question {
    private int id;
    private String statement;
    private List<String> answers;

    public Question(int id, String statement, List<String> answers) {
        this.statement = statement;
        this.answers = answers;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStatement() {
        return statement;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
