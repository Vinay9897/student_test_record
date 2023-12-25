package com.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.result.entities.ResultEntity;
import com.result.service.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {
	
	@Autowired
	ResultService resultService;
	
	public ResultController(ResultService resultService) {
		super();
		this.resultService = resultService;
	}
	
	@PostMapping("/add")
	public void addResult(@RequestBody ResultEntity result) {
		resultService.add(result);
	}
	
	@GetMapping("quiz/{quizId}")
	public ResultEntity getResultOfQuiz(@PathVariable Long quizId) {
		
		return resultService.getResultOfQuiz(quizId);
	}
	
	@GetMapping("/")
	public List<ResultEntity> get()
	{
		return resultService.get();
	}

}
