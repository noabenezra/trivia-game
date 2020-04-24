package com.example.demo.services;

import com.example.demo.models.entities.TriviaGameEntity;

import java.util.List;

public interface TriviaGameService {
    List<TriviaGameEntity> getQuestionsList();
}
