package com.example.demo.controller;

import com.example.demo.models.entities.TriviaGameEntity;
import com.example.demo.models.entities.UsersEntity;
import com.example.demo.payload.request.UserRequest;
import com.example.demo.payload.response.UpdateUserResponse;
import com.example.demo.services.TriviaGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/add")
    public Integer addUser(@Valid @RequestBody UserRequest userRequest) {
        Integer result = triviaGameService.registerUser(userRequest);
        return result;
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateUserResponse> updateUser(@Valid @RequestBody UserRequest userRequest) {
        UpdateUserResponse response = triviaGameService.updateUser(userRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllUsers")
    public List<UsersEntity> getUsers() {
        List<UsersEntity> result = triviaGameService.getUsers();
        return result;
    }

}
