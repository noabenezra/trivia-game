package com.example.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsListResponse {
    private int questionId;
    private String question;
    private String answer;
    private int answerId;


}
