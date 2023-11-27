package com.quiz.controller;

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

import com.quiz.entities.QuizEntity;
import com.quiz.services.QuizServices;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizServices quizServices;
	
	public QuizController(QuizServices quizServices) {
		super();
		this.quizServices = quizServices;
	}
	
	@PostMapping("/add")
	public ResponseEntity<QuizEntity> addQuiz(@RequestBody QuizEntity quizEntity){	
		return new ResponseEntity<QuizEntity>(this.quizServices.add(quizEntity),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<QuizEntity>> getQuiz(){
		List<QuizEntity> list = this.quizServices.get();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/quizId/{quizId}")
	public ResponseEntity<QuizEntity> getOne(@PathVariable Long quizId){
		QuizEntity quiz = this.quizServices.get(quizId);
		return new ResponseEntity<>(quiz,HttpStatus.OK);
	}
}
