package com.example.HustLearning.repository;

import com.example.HustLearning.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

    @Query("select v from Vocabulary v where v.topic.id = :topicId")
    public List<Vocabulary> findVocabulariesByTopicId(@Param("topicId") long topicId);
}
