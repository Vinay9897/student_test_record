package com.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.result.entities.ResultEntity;
import com.result.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultRepository  repository;
	
	@Override
	public void add(ResultEntity result) {
		
		this.repository.save(result);
	}

	@Override
	public ResultEntity getResultOfQuiz(Long quizId) {
		return repository.findById(quizId).orElseThrow(() -> new RuntimeException("Result" + quizId + " is not Found"));
	}

	@Override
	public List<ResultEntity> get() {
		return repository.findAll();
	}

}
