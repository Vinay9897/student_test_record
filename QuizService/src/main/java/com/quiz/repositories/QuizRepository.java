package com.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entities.QuizEntity;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
	
}
