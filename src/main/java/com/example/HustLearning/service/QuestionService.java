package com.example.HustLearning.service;

import com.example.HustLearning.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestion();

    Question getQuestionById(long id);

    void addQuestion(Question question);

    Question deleteQuestionById(long id);

    List<Question> getQuestionsByTopicId(long topicId);
}
