package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.QuestionEntity;
import com.question.services.QuestionServices;


@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionServices questionServices;

	public QuestionController(QuestionServices questionServices) {
		super();
		this.questionServices = questionServices;
	}
	
	@PostMapping
	public ResponseEntity<String> addQuiz(@RequestBody QuestionEntity questionEntity){
			this.questionServices.add(questionEntity);
		return new ResponseEntity<String>("",HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<QuestionEntity>> getQuiz(){
		List<QuestionEntity> list = this.questionServices.get();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<QuestionEntity> getOne(@PathVariable Long questionId){
		QuestionEntity quiz = this.questionServices.get(questionId);
		return new ResponseEntity<>(quiz,HttpStatus.OK);
	}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<QuestionEntity>> getByQuizId(@PathVariable Long quizId){
		List<QuestionEntity> quiz = this.questionServices.getQuestionOfQuiz(quizId);
		return new ResponseEntity<>(quiz,HttpStatus.OK);
	}
	

}
