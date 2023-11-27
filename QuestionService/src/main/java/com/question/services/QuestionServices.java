package com.question.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entities.QuestionEntity;

@Service
public interface QuestionServices {
	
	QuestionEntity add(QuestionEntity quiz);
	
	QuestionEntity get(Long id);
	
	List<QuestionEntity> get();
	
	List<QuestionEntity> getQuestionOfQuiz(Long id);
}
