package com.example.demo.controller;

import com.example.demo.models.entities.TriviaGameEntity;
import com.example.demo.services.TriviaGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/trivia")
public class TriviaGameController {

    private final TriviaGameService triviaGameService;

    @Autowired
    public TriviaGameController(TriviaGameService triviaGameService) {
        this.triviaGameService = triviaGameService;
    }

    @GetMapping("/data")
    public List<TriviaGameEntity> getData() {
        List<TriviaGameEntity> result = triviaGameService.getQuestionsList();
        return result;
    }

}
