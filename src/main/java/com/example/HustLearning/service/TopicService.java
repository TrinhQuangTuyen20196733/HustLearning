package com.example.HustLearning.service;

import com.example.HustLearning.entity.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopic();

    Topic getTopicById(long id);

    void addTopic(Topic topic);

    Topic addAndReturnTopic(Topic topic);

    Topic deleteTopicById(long id);
}
