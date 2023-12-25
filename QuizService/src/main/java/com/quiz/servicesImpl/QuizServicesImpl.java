package com.quiz.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.QuizEntity;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizServices;
import com.quiz.services.ResultClient;

@Service
public class QuizServicesImpl implements QuizServices {

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	QuestionClient questionClient;
	
	@Autowired
	ResultClient resultClient;
	
	public QuizServicesImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}
	
	@Override
	public QuizEntity add(QuizEntity quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public QuizEntity get(Long id) {
		// TODO Auto-generated method stub
		QuizEntity quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz " + id + " not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		quiz.setResult(resultClient.getResultOfQuiz(quiz.getId()));
		return quiz;
	}

	@Override
	public List<QuizEntity> get() {
		// TODO Auto-generated method stub
		List<QuizEntity> newQuizzesList = quizRepository.findAll();
		newQuizzesList.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			quiz.setResult(resultClient.getResultOfQuiz(quiz.getId()));
			
			return quiz;
		}).collect(Collectors.toList());
		return newQuizzesList;
	}

}
