package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.AnswerDTO;
import com.example.HustLearning.dto.response.QuestionRes;
import com.example.HustLearning.entity.Answer;
import com.example.HustLearning.entity.Question;
import com.example.HustLearning.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class QuestionMapper implements Mapper<Question, QuestionRes> {

    private final AnwserMapper anwserMapper;
    @Override
    public Question toEntity(QuestionRes dto) {
        return null;
    }

    @Override
    public QuestionRes toDTO(Question entity) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Question, QuestionRes> typeMap =  modelMapper.createTypeMap(Question.class,QuestionRes.class);
        List<Answer> answers = entity.getAnswers();
        List<AnswerDTO> answerDTOList = anwserMapper.toDTOList(answers);
        typeMap.addMappings(mapping->mapping.map(src->answerDTOList,QuestionRes::setAnswerDTOS));

        return modelMapper.map(entity,QuestionRes.class);
    }

    @Override
    public List<QuestionRes> toDTOList(List<Question> entityList) {
        return null;
    }

    @Override
    public List<Question> toEntityList(List<QuestionRes> dtoList) {
        return null;
    }
}
