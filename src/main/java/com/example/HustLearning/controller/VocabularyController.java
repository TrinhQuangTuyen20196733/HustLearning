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
@RequestMapping("api/learning")
public class VocabularyController {

    private final VocabularySerivce vocabularySerivce;
    private final TopicService topicService;
    private final VocabularyMapper vocabularyMapper;

    @GetMapping("/vocabularies/{topicId}")
    public List<VocabularyDTO> getAllVocabularies(@PathVariable("topicId") long topicId) {

        if (topicService.getTopicById(topicId) != null) {
            List<Vocabulary> vocabularies = vocabularySerivce.getVocabulariesByTopicId(topicId);

            for (Vocabulary vocabulary :
                    vocabularies) {
                System.out.println(vocabulary.toString());
            }

            List<VocabularyDTO> vocabularyDTOS = vocabularyMapper.toDTOList(vocabularies);
            return vocabularyDTOS;
        }

        return null;
    }

    @DeleteMapping("/vocabulary/{id}")
    public MessagesResponse deleteVocabularyById(@PathVariable("id") long id) {

        if (vocabularySerivce.getVocabularyById(id) != null) {
            vocabularySerivce.deleteVocabularyById(id);
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Deleted successfully!").data(vocabularySerivce.getVocabularyById(id)).build();
        }

        return MessagesResponse.builder().code(HttpStatus.NOT_FOUND.value()).message("Deletion failed with vocabulary id: " + id).data(null).build();
    }

    @PostMapping("/vocabulary")
    public MessagesResponse addVocabulary(@RequestBody @Valid VocabularyDTO vocabularyDTO) {
        Vocabulary vocabulary = vocabularyMapper.toEntity(vocabularyDTO);

        System.out.println(vocabulary);

        if (vocabularySerivce.addAndReturnVocabulary(vocabulary) !=null) {
            return MessagesResponse.builder().code(HttpStatus.OK.value()).message("Saved successfully!").data(vocabularyDTO).build();
        }

        return MessagesResponse.builder().code(HttpStatus.BAD_REQUEST.value()).message("Could not add a vocabulary").data(vocabularyDTO).build();
    }
}
