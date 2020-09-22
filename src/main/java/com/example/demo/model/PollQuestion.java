package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PollQuestions")

public class PollQuestion implements Serializable {
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "question_text")
	private String questionText;

	public PollQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PollQuestion(long id, String questionText) {
		super();
		this.id = id;
		this.questionText = questionText;
	}

	public PollQuestion(String questionText) {
		super();
		this.questionText = questionText;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questinText) {
		this.questionText = questinText;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PollQuestion)) {
			return false;
		}
		PollQuestion question = (PollQuestion) obj;
		return this.id == question.getId();
	}

}