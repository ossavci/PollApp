package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserAnswers", uniqueConstraints = @UniqueConstraint(columnNames = { "questionId", "userId" }))
public class UserAnswers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "questionId")
	private long questionId;
	@Column(name = "optionId")
	private long optionId;
	@Column(name = "userId")
	private long userId;

	
	public UserAnswers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAnswers(long questionId, long optionId, long userId) {
		super();
		this.questionId = questionId;
		this.optionId = optionId;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
