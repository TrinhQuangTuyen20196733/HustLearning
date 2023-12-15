package com.example.HustLearning.service.Impl;

import com.example.HustLearning.entity.Question;
import com.example.HustLearning.repository.QuestionRepository;
import com.example.HustLearning.repository.TopicRepository;
import com.example.HustLearning.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);

        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        }

        return null;
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question deleteQuestionById(long id) {
        Optional<Question>  optionalQuestion = questionRepository.findById(id);

        if (optionalQuestion.isPresent()) {
            questionRepository.deleteById(id);
            return optionalQuestion.get();
        }

        return null;
    }

    @Override
    public List<Question> getQuestionsByTopicId(long topicId) {
        if (topicRepository.findById(topicId).isPresent()) {
            return questionRepository.findQuestionsByTopicId(topicId);
        }

        return null;
    }
}
