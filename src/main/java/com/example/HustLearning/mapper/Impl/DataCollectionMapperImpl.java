package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.response.DataCollectionRes;
import com.example.HustLearning.entity.DataCollection;
import com.example.HustLearning.mapper.DataCollectionMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataCollectionMapperImpl implements DataCollectionMapper {

  @Override
  public DataCollectionRes toDTO(DataCollection entity) {
    ModelMapper modelMapper = new ModelMapper();

    DataCollectionRes dataCollectionRes = modelMapper.map(entity, DataCollectionRes.class);
    dataCollectionRes.setVocabId(entity.getVocab().getId());
    return dataCollectionRes;

  }

  @Override
  public List<DataCollectionRes> toDTOList(List<DataCollection> entityList) {
    return entityList.stream().map(entity->toDTO(entity)).collect(Collectors.toList());
  }
}
