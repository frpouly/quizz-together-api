package com.quizztogether.api.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stream/game")
public class SSEGameController {

    public static HashMap<String, List<SseEmitter>> emittersForNewRound = new HashMap<>();

    @GetMapping("/{idGame}/new_round")
    public SseEmitter streamWhenNewRound(@PathVariable String idGame) throws IOException {
        SseEmitter emitter = new SseEmitter();
        if(!emittersForNewRound.containsKey(idGame))
            emittersForNewRound.put(idGame, new ArrayList<>());
        emittersForNewRound.get(idGame).add(emitter);
        emitter.onCompletion(() -> emittersForNewRound.get(idGame).remove(emitter));
        return emitter;
    }
}
