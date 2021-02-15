package com.quizztogether.api;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.List;
import java.util.ArrayList;

public class Question {
    private String statement;
    private List<String> answers = new ArrayList<>();

    public Question(String statement, List<String> answers) {
        this.statement = statement;
        this.answers = answers;
    }

    public String getStatement() {
        return statement;
    }

    public List<String> getAnswers() {
        return new UnmodifiableArrayList<>(answers.toArray(new String[0]), answers.size());
    }
}
