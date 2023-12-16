package com.example.HustLearning.controller;

import com.example.HustLearning.dto.TopicDTO;
import com.example.HustLearning.dto.response.MessagesResponse;
import com.example.HustLearning.entity.Topic;
import com.example.HustLearning.mapper.Impl.TopicMapper;
import com.example.HustLearning.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/learning")
public class TopicController {
    private final TopicService topicService;
    private final TopicMapper topicMapper;

    @GetMapping("/topics")
    public List<TopicDTO> getAllTopic(){
        List<Topic> topics = topicService.getAllTopic();
        List<TopicDTO> topicDTOS = topicMapper.toDTOList(topics);

        return topicDTOS;
    }

    @PostMapping
    public MessagesResponse addTopic(@RequestBody @Valid TopicDTO topicDTO) {
        Topic topic = topicMapper.toEntity(topicDTO);

        if (topicService.addAndReturnTopic(topic) !=null) {
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Saved successfully!").data(topicDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.BAD_REQUEST.value()).message("Could not add a vocabulary").data(topicDTO).build();
    }

    @DeleteMapping("/topic/{id}")
    public MessagesResponse deleteTopic(@PathVariable("id") long id) {
        if (topicService.getTopicById(id) != null) {
            Topic topic = topicService.deleteTopicById(id);
            TopicDTO topicDTO = topicMapper.toDTO(topic);
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Deleted successfully!").data(topicDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.NOT_FOUND.value()).message("Deletion failed with topic id: " + id).data(null).build();
    }

}
