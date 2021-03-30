package com.quizztogether.api.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SSEController {

    public static HashMap<String, List<SseEmitter>> emittersToClients = new HashMap<>();



}
