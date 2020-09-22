package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PollAnswers")
public class PollOption implements Serializable {

	private static final long serialVersionUID = -4781750817337514145L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "questions_id")
	private long questionId;
	@Column(name = "option_text")
	private String optionText;
	@Column(name = "count")
	private Integer count = 0;

	public PollOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PollOption(long id, long questionId, String optionText) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.optionText = optionText;
	}

	public PollOption(long questionId, String optionText) {
		super();
		this.questionId = questionId;
		this.optionText = optionText;
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

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public PollOption addCount() {
		this.count++;
		return this;
	}

}
