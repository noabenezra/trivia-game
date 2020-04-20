package com.example.demo.services;

import com.example.demo.models.entities.TriviaGameEntity;
import com.example.demo.payload.response.QuestionsListResponse;

import java.util.List;

public interface TriviaGameService {
    List<TriviaGameEntity> getQuestionsList();
}
