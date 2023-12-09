package com.example.HustLearning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topic")
@Entity
public class Topic extends BaseEntity{
    private String content;

    private String imageLocation;

    private  String videoLocation;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "topic",cascade = CascadeType.PERSIST)
    private List<Vocabulary> vocabularies;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vocab_id")
    private List<Question> questions;

}
