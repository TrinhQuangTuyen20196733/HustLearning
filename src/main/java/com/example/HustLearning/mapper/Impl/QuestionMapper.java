package com.example.HustLearning.mapper.Impl;

import com.example.HustLearning.dto.AnswerDTO;
import com.example.HustLearning.dto.QuestionDTO;
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
public class QuestionMapper implements Mapper<Question, QuestionDTO> {

    private final AnwserMapper anwserMapper;

    @Override
    public Question toEntity(QuestionDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<QuestionDTO, Question> typeMap =  modelMapper.createTypeMap(QuestionDTO.class,Question.class);

        List<AnswerDTO> answerDTOS = dto.getAnswerDTOS();
        List<Answer> answers = anwserMapper.toEntityList(answerDTOS);
        typeMap.addMappings(mapping->mapping.map(src->answers,Question::setAnswers));

        return modelMapper.map(dto,Question.class);
    }

    @Override
    public QuestionDTO toDTO(Question entity) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Question, QuestionDTO> typeMap =  modelMapper.createTypeMap(Question.class, QuestionDTO.class);

        List<Answer> answers = entity.getAnswers();
        List<AnswerDTO> answerDTOList = anwserMapper.toDTOList(answers);
        typeMap.addMappings(mapping->mapping.map(src->answerDTOList, QuestionDTO::setAnswerDTOS));

        return modelMapper.map(entity, QuestionDTO.class);
    }

    @Override
    public List<QuestionDTO> toDTOList(List<Question> entityList) {
        return null;
    }

    @Override
    public List<Question> toEntityList(List<QuestionDTO> dtoList) {
        return null;
    }

}
