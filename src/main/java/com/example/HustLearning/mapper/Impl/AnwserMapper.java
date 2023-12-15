package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.AnswerDTO;
import com.example.HustLearning.entity.Answer;
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
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(dto, Answer.class);
    }

    @Override
    public AnswerDTO toDTO(Answer entity) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(entity,AnswerDTO.class);
    }

    @Override
    public List<AnswerDTO> toDTOList(List<Answer> entityList) {
        return entityList.stream().map(entity->toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Answer> toEntityList(List<AnswerDTO> dtoList) {
        return dtoList.stream().map(dto->toEntity(dto)).collect(Collectors.toList());
    }

}
