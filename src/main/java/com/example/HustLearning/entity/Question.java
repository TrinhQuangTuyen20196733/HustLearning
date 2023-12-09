package com.example.HustLearning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@Entity
public class Question extends BaseEntity {

    private String content;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Answer> answers;

    private String explain;

    private String imageLocation;

    private  String videoLocation;

}
