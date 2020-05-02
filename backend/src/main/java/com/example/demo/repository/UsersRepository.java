package com.example.demo.repository;

import com.example.demo.models.entities.TriviaGameEntity;
import com.example.demo.models.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}

