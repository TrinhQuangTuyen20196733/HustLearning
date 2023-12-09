package com.example.HustLearning.dto.response;

import com.example.HustLearning.dto.AnswerDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionRes {
    private String content;

    private String explain;

    private String imageLocation;

    private  String videoLocation;

    private List<AnswerDTO> answerDTOS;
}
