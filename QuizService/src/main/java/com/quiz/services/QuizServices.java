package com.quiz.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.entities.QuizEntity;

@Service
public interface QuizServices {

	QuizEntity add(QuizEntity quiz);
	
	QuizEntity get(Long id);
	
	List<QuizEntity> get();
}
