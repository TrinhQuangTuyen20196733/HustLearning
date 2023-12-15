package com.example.HustLearning;

import com.example.HustLearning.entity.Answer;
import com.example.HustLearning.service.AnswerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HustLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HustLearningApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AnswerService answerService) {
		return runner -> {
//			System.out.println(answerService.getAnswerById(1).getQuestion().getId());

//			List<Answer> answers = answerService.getAllAnswer();
//
//			for (Answer answer :
//					answers) {
//				System.out.println(answer.toString());
//			}

//			System.out.println("Answer: " + answerService.getAnswerById(-1));

//			List<Answer> answers = answerService.getAnswersByQuestionId(1);
//
//			for (Answer answer:
//				 answers) {
//				System.out.println(answer);
//			}
		};


	}
}
