package com.example.demo.services;

import com.example.demo.models.entities.TriviaGameEntity;
import com.example.demo.models.entities.UsersEntity;
import com.example.demo.payload.request.UserRequest;
import com.example.demo.payload.response.UpdateUserResponse;
import com.example.demo.payload.response.UserResponse;

import java.util.List;

public interface TriviaGameService {
    List<TriviaGameEntity> getQuestionsList();

    Integer registerUser(UserRequest userRequest);

    UpdateUserResponse updateUser(UserRequest userRequest);

    List<UsersEntity> getUsers();
}
