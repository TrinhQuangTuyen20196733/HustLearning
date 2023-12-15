package com.example.HustLearning.repository;

import com.example.HustLearning.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("select q from Question q where q.topic.id = :topicId")
    public List<Question> findQuestionsByTopicId(@Param("topicId") long topicId);
}
