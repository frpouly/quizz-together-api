package com.quizztogether.api.Models;

import com.quizztogether.api.Models.Answer;

import java.util.HashMap;
import java.util.List;

public class Question {
    private int id;
    private String statement;
    private List<Answer> answers;

    public Question(int id, String statement, List<Answer> answers) {
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

    public List<Answer> getAnswers() {
        return answers;
    }
}
