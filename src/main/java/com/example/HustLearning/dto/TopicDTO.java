package com.example.HustLearning.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicDTO {
    private String content;

    private String imageLocation;

    private  String videoLocation;
}
