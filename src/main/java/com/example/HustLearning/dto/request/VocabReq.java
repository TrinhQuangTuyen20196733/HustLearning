package com.example.HustLearning.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VocabReq{

    private String content;

    private String imageLocation;

    private  String videoLocation;

    private  long topic_id;

}
