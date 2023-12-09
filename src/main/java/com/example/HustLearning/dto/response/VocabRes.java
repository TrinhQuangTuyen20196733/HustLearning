package com.example.HustLearning.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VocabRes {
    private String content;

    private String imageLocation;

    private  String videoLocation;
}
