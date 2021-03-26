package com.quizztogether.api.Models;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class Round {

    final
    QuestionService service;

    private Question question;
    private HashMap<Integer, List<Integer>> answersMap = new HashMap<>();

    public Round(QuestionService service) throws ExecutionException, InterruptedException {
        this.service = service;
        question = service.getRandomQuestion();
        for (int i = 0; i < question.getAnswers().size(); i++) {
            answersMap.put(i, new LinkedList<>());
        }
    }

    public boolean addAnswer(int p, int answer) {
        if(answersMap.size() <= answer) {
            return false;
        }
        answersMap.get(answer).add(p);
        return true;
    }

    public Question getQuestion() {
        return question;
    }

    public HashMap<Integer, List<Integer>> getAnswers() {
        return answersMap;
    }

    public List<Integer> getWinners() {
        List<Integer> winners = new LinkedList<>();
        int max = 0;
        for(List<Integer> players : answersMap.values()) {
            int playersSize = players.size();
            if(playersSize == max)
                winners.addAll(players);
            else if(playersSize > max) {
                max = playersSize;
                winners.clear();
                winners.addAll(players);
            }
        }
        return winners;
    }
}
