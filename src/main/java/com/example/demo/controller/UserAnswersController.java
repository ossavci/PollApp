package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PollQuestion;
import com.example.demo.model.UserAnswers;
import com.example.demo.repository.UserAnswersRepository;

@RestController
public class UserAnswersController {
	@Autowired
	UserAnswersRepository repository;
	@Autowired
	QuestionController questionsController;

	public String addUserAnswer(UserAnswers user) {
		repository.save(user);
		return "answer added";
	}

	public List<UserAnswers> getAnsweredQuestionListWithAnswers(long userid) {
		List<UserAnswers> answerList = repository.findByUserId(userid);
		return answerList;
	}

	public List<PollQuestion> getAnsweredQuestionList(long userid) {
		List<UserAnswers> answerList = repository.findByUserId(userid);
		List<PollQuestion> questionList = new ArrayList<PollQuestion>();
		for (UserAnswers answer : answerList) {
			questionList.add(questionsController.getQuestionById(answer.getQuestionId()));
		}
		return questionList;
	}

}