package com.example.HustLearning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private long id;

    private String content;

    private String explanation;

    private String imageLocation;

    private  String videoLocation;

    private long topic_id;

    private List<AnswerDTO> answerDTOS;

}
