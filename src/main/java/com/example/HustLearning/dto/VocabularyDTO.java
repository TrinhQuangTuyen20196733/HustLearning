package com.example.HustLearning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VocabularyDTO {
    private long id;

    private String content;

    private String imageLocation;

    private  String videoLocation;

    private  long topic_id;

}
