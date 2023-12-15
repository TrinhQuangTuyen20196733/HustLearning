package com.example.HustLearning.service.Impl;

import com.example.HustLearning.entity.Vocabulary;
import com.example.HustLearning.repository.TopicRepository;
import com.example.HustLearning.repository.VocabularyRepository;
import com.example.HustLearning.service.VocabularySerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VocabularyServiceImpl implements VocabularySerivce {

    private final VocabularyRepository vocabularyRepository;
    private final TopicRepository topicRepository;

    @Override
    public List<Vocabulary> getAllVocabulary() {
        return vocabularyRepository.findAll();
    }

    @Override
    public Vocabulary getVocabularyById(long id) {
        Optional<Vocabulary> optionalVocabulary = vocabularyRepository.findById(id);

        if (optionalVocabulary.isPresent()) {
            return optionalVocabulary.get();
        }

        return null;
    }

    @Override
    public void addVocabulary(Vocabulary vocabulary) {
        vocabularyRepository.save(vocabulary);
    }

    @Override
    public Vocabulary addAndReturnVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.save(vocabulary);
    }

    @Override
    public Vocabulary deleteVocabularyById(long id) {
        Optional<Vocabulary> optionalVocabulary = vocabularyRepository.findById(id);

        if (optionalVocabulary.isPresent()) {
            vocabularyRepository.deleteById(id);
            return optionalVocabulary.get();
        }

        return null;
    }

    @Override
    public List<Vocabulary> getVocabulariesByTopicId(long topicId) {
        if (topicRepository.findById(topicId).isPresent()) {
            return vocabularyRepository.findVocabulariesByTopicId(topicId);
        }

        return null;
    }
}
