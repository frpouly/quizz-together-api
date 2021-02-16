package com.quizztogether.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class QuestionController {

    final
    QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/api/questions")
    public List<Question> getAllQuestions() throws ExecutionException, InterruptedException {
        return service.getQuestions();
    }

    @GetMapping("/api/questions/random")
    public Question getRandomQuestion() throws ExecutionException, InterruptedException {
        return service.getRandomQuestion();
    }
}
