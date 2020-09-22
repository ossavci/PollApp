package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

public class QuestionsWithOptions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PollQuestion question;
	private List<PollOption> optionList;
	
	public PollQuestion getQuestion() {
		return question;
	}
	
	public QuestionsWithOptions(PollQuestion question, List<PollOption> optionList) {
		super();
		this.question = question;
		this.optionList = optionList;
	}

	public QuestionsWithOptions() {
		// TODO Auto-generated constructor stub
	}

	public void setQuestion(PollQuestion question) {
		this.question = question;
	}
	public List<PollOption> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<PollOption> optionList) {
		this.optionList = optionList;
	}
	
	

}
