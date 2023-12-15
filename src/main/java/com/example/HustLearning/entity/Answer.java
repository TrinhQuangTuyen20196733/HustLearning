package com.example.HustLearning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "question")
@Table(name = "answer")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "answer_id"))
public class Answer extends BaseEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "image_location")
    private String imageLocation;

    @Column(name = "video_location")
    private  String videoLocation;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="question_id")
    private Question question;

}
