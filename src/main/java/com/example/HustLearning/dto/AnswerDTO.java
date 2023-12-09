package com.example.HustLearning.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    private String content;

    private boolean isCorrect;

    private String imageLocation;

    private  String videoLocation;
}
