package com.example.HustLearning.service.Impl;


import com.example.HustLearning.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl {
    private  final TopicRepository topicRepository;

}
