package com.example.HustLearning.controller;

import com.example.HustLearning.dto.VocabularyDTO;
import com.example.HustLearning.dto.response.MessagesResponse;
import com.example.HustLearning.entity.Vocabulary;
import com.example.HustLearning.mapper.Impl.VocabularyMapper;
import com.example.HustLearning.service.TopicService;
import com.example.HustLearning.service.VocabularySerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vocabularies")
public class VocabularyController {

    private final VocabularySerivce vocabularySerivce;
    private final TopicService topicService;
    private final VocabularyMapper vocabularyMapper;

    @GetMapping("/{topicId}")
    public MessagesResponse getAllVocabularies(@PathVariable("topicId") long topicId) {
        MessagesResponse ms = new MessagesResponse();
        try {
            if (topicService.getTopicById(topicId) != null) {
                List<Vocabulary> vocabularies = vocabularySerivce.getVocabulariesByTopicId(topicId);

                List<VocabularyDTO> vocabularyDTOS = vocabularyMapper.toDTOList(vocabularies);
                ms.data = vocabularyDTOS;
            }

        } catch (Exception ex) {
            ms.code = 404;
            ms.message = ex.getMessage();
        }

        return ms;
    }

    @PostMapping
    public MessagesResponse addVocabulary(@RequestBody @Valid VocabularyDTO vocabularyDTO) {
        Vocabulary vocabulary = vocabularyMapper.toEntity(vocabularyDTO);

        if (vocabularySerivce.addAndReturnVocabulary(vocabulary) != null) {
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Saved successfully!").data(vocabularyDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.BAD_REQUEST.value()).message("Could not add a vocabulary").data(vocabularyDTO).build();
    }

    @DeleteMapping("/{id}")
    public MessagesResponse deleteVocabularyById(@PathVariable("id") long id) {

        if (vocabularySerivce.getVocabularyById(id) != null) {
            Vocabulary vocabulary = vocabularySerivce.deleteVocabularyById(id);
            VocabularyDTO vocabularyDTO = vocabularyMapper.toDTO(vocabulary);
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Deleted successfully!").data(vocabularyDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.NOT_FOUND.value()).message("Deletion failed with vocabulary id: " + id).data(null).build();
    }
}
