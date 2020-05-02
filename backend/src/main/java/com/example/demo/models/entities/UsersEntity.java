package com.example.demo.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Users")
public class UsersEntity {
    @Id
    @SequenceGenerator(name = "Users_seq", sequenceName = "Users_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "Users_seq")
    @NotNull
    Integer id;

    String name;

    Integer score;

    Integer numberOfAnswerQuestions;

    public UsersEntity() {

    }

    public UsersEntity(String name, Integer score, Integer numberOfAnswerQuestions) {
        this.name = name;
        this.score = score;
        this.numberOfAnswerQuestions = numberOfAnswerQuestions;

    }
}
