package com.example.HustLearning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@ToString(exclude = {"topic", "answers"})
@Entity
@AttributeOverride(name = "id", column = @Column(name = "question_id"))
public class Question extends BaseEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "image_location")
    private String imageLocation;

    @Column(name = "video_location")
    private  String videoLocation;

    @JsonIgnore
    @OneToMany(mappedBy = "question",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH,
                    CascadeType.REMOVE})
    private List<Answer> answers;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="topic_id")
    private Topic topic;

}
