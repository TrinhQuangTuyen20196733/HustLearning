package com.example.HustLearning.service.Impl;


import com.example.HustLearning.entity.Topic;
import com.example.HustLearning.repository.TopicRepository;
import com.example.HustLearning.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private  final TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            return optionalTopic.get();
        }

        return null;
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public Topic deleteTopicById(long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            topicRepository.deleteById(id);
            return optionalTopic.get();
        }

        return null;
    }
}
