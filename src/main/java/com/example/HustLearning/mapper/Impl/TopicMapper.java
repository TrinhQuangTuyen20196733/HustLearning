package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.TopicDTO;
import com.example.HustLearning.entity.Topic;
import com.example.HustLearning.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicMapper implements Mapper<Topic, TopicDTO> {

    @Override
    public Topic toEntity(TopicDTO dto) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(dto, Topic.class);
    }

    @Override
    public TopicDTO toDTO(Topic entity) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(entity, TopicDTO.class);
    }

    @Override
    public List<TopicDTO> toDTOList(List<Topic> entityList) {
        return entityList.stream().map(entity->toDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Topic> toEntityList(List<TopicDTO> dtoList) {
        return dtoList.stream().map(dto->toEntity(dto)).collect(Collectors.toList());
    }

}
