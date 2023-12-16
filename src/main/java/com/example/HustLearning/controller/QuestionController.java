package com.example.HustLearning.controller;


import com.example.HustLearning.dto.QuestionDTO;
import com.example.HustLearning.dto.response.MessagesResponse;
import com.example.HustLearning.entity.Answer;
import com.example.HustLearning.entity.Question;
import com.example.HustLearning.mapper.Impl.QuestionMapper;
import com.example.HustLearning.service.QuestionService;
import com.example.HustLearning.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;
    private final TopicService topicService;
    private final QuestionMapper questionMapper;

    @GetMapping("/{topicId}")
    public MessagesResponse getAllQuestion(@PathVariable("topicId") long topicId) {
        MessagesResponse ms = new MessagesResponse();
        try {
            if (topicService.getTopicById(topicId) != null) {
                List<Question> questions = questionService.getQuestionsByTopicId(topicId);
                List<QuestionDTO> questionDTOS = questionMapper.toDTOList(questions);
                ms.data = questionDTOS;
            }
        } catch (Exception ex) {
            ms.code = 404;
            ms.message = ex.getMessage();
        }


        return ms;
    }

    @PostMapping
    public MessagesResponse addQuestion(@RequestBody @Valid QuestionDTO questionDTO) {
        Question question = questionMapper.toEntity(questionDTO);

        if (questionService.addQuestionAndAnswers(question) != null) {
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Saved successfully!").data(questionDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.BAD_REQUEST.value()).message("Updated error!").data(questionDTO).build();
    }

    @DeleteMapping("/{id}")
    public MessagesResponse deleteQuestion(@PathVariable long id) {
        if (questionService.getQuestionById(id) != null) {
            Question question = questionService.deleteQuestionById(id);
            QuestionDTO questionDTO = questionMapper.toDTO(question);
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Deleted successfully!: " + id).data(questionDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.NOT_FOUND.value()).message("Deletion failed with question id: " + id).build();

    }
}
