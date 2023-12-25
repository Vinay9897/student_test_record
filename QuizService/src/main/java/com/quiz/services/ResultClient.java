package com.quiz.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.ResultEntity;

//@FeignClient(url="http://localhost:8085",value="RESULT-SERVICE")
@FeignClient(name="RESULT-SERVICE")
public interface ResultClient {

	@GetMapping("/result/quiz/{quizId}")
	ResultEntity getResultOfQuiz(@PathVariable Long quizId);
}
