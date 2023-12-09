package com.example.HustLearning.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VocabReq {
    private String content;

    private String imageLocation;

    private  String videoLocation;

    private  int topic_id;
}
