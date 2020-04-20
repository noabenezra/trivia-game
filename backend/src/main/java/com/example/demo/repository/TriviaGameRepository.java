package com.example.demo.repository;

import com.example.demo.models.entities.TriviaGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaGameRepository extends JpaRepository<TriviaGameEntity, Integer> {

}
