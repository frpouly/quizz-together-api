package com.quizztogether.api.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SSEGameController {

    public static HashMap<String, List<SseEmitter>> emittersForNewRound = new HashMap<>();
    public static HashMap<String, SseEmitter> emittersForNewPlayer = new HashMap<>();
    @CrossOrigin
    @GetMapping("/stream/game/{idGame}/new_round")
    public SseEmitter streamWhenNewRound(@PathVariable String idGame) throws IOException {
        SseEmitter emitter = new SseEmitter(86400000L);
        if(!emittersForNewRound.containsKey(idGame))
            emittersForNewRound.put(idGame, new ArrayList<>());
        emittersForNewRound.get(idGame).add(emitter);
        emitter.onCompletion(() -> emittersForNewRound.get(idGame).remove(emitter));
        return emitter;
    }
    @CrossOrigin
    @GetMapping("/stream/game/{idGame}/new_player")
    public SseEmitter getNewPlayer(@PathVariable String idGame) {
        SseEmitter emitter = new SseEmitter(86400000L);
        emittersForNewPlayer.put(idGame, emitter);
        emitter.onCompletion(() -> emittersForNewPlayer.remove(idGame));
        return emitter;
    }
}
