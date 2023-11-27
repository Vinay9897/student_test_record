package com.question.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.QuestionEntity;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionServices;

@Service
public class QuestionServiceImpl implements QuestionServices{

	@Autowired
	QuestionRepository questionRepository;
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public QuestionEntity add(QuestionEntity quiz) {
		return questionRepository.save(quiz);
	}

	@Override
	public QuestionEntity get(Long id) {
		
		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question" + id + " is not found"));
	}

	@Override
	public List<QuestionEntity> get() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public List<QuestionEntity> getQuestionOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuizId(quizId);
	}
	
}
