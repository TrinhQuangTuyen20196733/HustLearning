package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.AnswerDTO;
import com.example.HustLearning.dto.response.QuestionRes;
import com.example.HustLearning.entity.Answer;
import com.example.HustLearning.entity.Question;
import com.example.HustLearning.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnwserMapper implements Mapper<Answer, AnswerDTO> {
    @Override
    public Answer toEntity(AnswerDTO dto) {
        return null;
    }

    @Override
    public AnswerDTO toDTO(Answer entity) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Answer, AnswerDTO> typeMap =  modelMapper.createTypeMap(Answer.class,AnswerDTO.class);
        return modelMapper.map(entity,AnswerDTO.class);
    }

    @Override
    public List<AnswerDTO> toDTOList(List<Answer> entityList) {
        return entityList.stream().map(entity->toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Answer> toEntityList(List<AnswerDTO> dtoList) {
        return null;
    }
}
