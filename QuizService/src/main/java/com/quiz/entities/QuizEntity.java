package com.quiz.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="tbl_quiz")
@Entity
public class QuizEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	transient private List<QuestionEntity> questions;
	
	public QuizEntity(Long id, String title, List<QuestionEntity> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questions = questions;
	}
	
	public List<QuestionEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionEntity> list) {
		this.questions = list;
	}
	@Override
	public String toString() {
		return "QuizEntity [id=" + id + ", title=" + title + ", questions=" + questions + "]";
	}
	public QuizEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizEntity(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
