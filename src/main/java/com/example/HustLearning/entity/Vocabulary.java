package com.example.HustLearning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vocab")
@Entity
public class Vocabulary extends BaseEntity{
    private String content;

    private String videoLocation;

    private String imageLocation;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;





}
