package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.AnswerDTO;
import com.example.HustLearning.dto.QuestionDTO;
import com.example.HustLearning.dto.TopicDTO;
import com.example.HustLearning.dto.VocabularyDTO;
import com.example.HustLearning.entity.Answer;
import com.example.HustLearning.entity.Question;
import com.example.HustLearning.entity.Topic;
import com.example.HustLearning.entity.Vocabulary;
import com.example.HustLearning.mapper.Mapper;
import com.example.HustLearning.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class VocabularyMapper implements Mapper<Vocabulary, VocabularyDTO> {

    private final TopicRepository topicRepository;

    @Override
    public Vocabulary toEntity(VocabularyDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Vocabulary vocabulary = modelMapper.map(dto, Vocabulary.class);

        long topicId = dto.getTopic_id();
        Topic topic = topicRepository.findById(topicId).get();
        vocabulary.setTopic(topic);

        return vocabulary;
    }

    @Override
    public VocabularyDTO toDTO(Vocabulary entity) {
        ModelMapper modelMapper = new ModelMapper();
        VocabularyDTO vocabularyDTO = modelMapper.map(entity, VocabularyDTO.class);

        long topicId = entity.getTopic().getId();
        vocabularyDTO.setTopic_id(topicId);

        return vocabularyDTO;
    }

    @Override
    public List<VocabularyDTO> toDTOList(List<Vocabulary> entityList) {
        return entityList.stream().map(entity->toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Vocabulary> toEntityList(List<VocabularyDTO> dtoList) {
        return dtoList.stream().map(dto->toEntity(dto)).collect(Collectors.toList());
    }

}
