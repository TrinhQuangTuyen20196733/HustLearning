package com.example.HustLearning.service;

import com.example.HustLearning.entity.Vocabulary;

import java.util.List;

public interface VocabularySerivce {

    List<Vocabulary> getAllVocabulary();

    Vocabulary getVocabularyById(long id);

    void addVocabulary(Vocabulary vocabulary);

    Vocabulary addAndReturnVocabulary(Vocabulary vocabulary);

    Vocabulary deleteVocabularyById(long id);

    List<Vocabulary> getVocabulariesByTopicId(long topicId);
}
