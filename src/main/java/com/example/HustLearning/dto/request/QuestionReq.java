package com.example.HustLearning.dto.request;

import com.example.HustLearning.dto.AnswerDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionReq {
    private String content;
    private String explain;
    private String imageLocation;
    private  String videoLocation;
    private int topic_id;
    private List<AnswerDTO> answerReqList;


}
