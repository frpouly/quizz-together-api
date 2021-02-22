package com.quizztogether.api.Models;

public class Answer {
    private int id;
    private String statement;

    public Answer() {

    }

    public Answer(int id, String statement) {
        this.id = id;
        this.statement = statement;
    }

    public Answer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStatement() {
        return statement;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass() != this.getClass()) {
            return false;
        }
        Answer a = (Answer) o;
        return a.id == this.id;
    }
}
