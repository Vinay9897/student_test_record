package com.question.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="tbl_ques")
public class QuestionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	
	private String question;
	
	private Long quizId;
	

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public QuestionEntity(Long questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public QuestionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionEntity [questionId=" + questionId + ", question=" + question + "]";
	}
	
	

	
}
