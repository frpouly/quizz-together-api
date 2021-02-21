package com.quizztogether.api;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.List;
import java.util.ArrayList;

public class Question {
    private String id;
    private String statement;
    private List<Answer> answers;

    public Question(String id, String statement, List<Answer> answers) {
        this.statement = statement;
        this.answers = answers;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getStatement() {
        return statement;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
