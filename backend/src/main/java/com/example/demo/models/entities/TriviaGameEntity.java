package com.example.demo.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TriviaGame")
public class TriviaGameEntity {
    @Id
    @SequenceGenerator(name = "TriviaGame_seq", sequenceName = "TriviaGame_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "TriviaGame_seq")
    Integer id;
    @NotNull
    String question;
    @NotNull
    String answer;
    @NotNull
    String hint;
    @NotNull
    Integer difficulty;
    @NotNull
    String success;


}
