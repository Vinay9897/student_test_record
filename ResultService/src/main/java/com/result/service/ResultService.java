package com.result.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.result.entities.ResultEntity;

@Service
public interface ResultService{
	
	public void add(ResultEntity result);
	
	public ResultEntity getResultOfQuiz(Long quizId);
	
	public List<ResultEntity> get();
}



