package com.result.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="tbl_result")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizId;
	private String result;

}
