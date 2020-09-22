package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PollOption;
import com.example.demo.model.PollQuestion;
import com.example.demo.model.PollUser;
import com.example.demo.model.QuestionsWithOptions;
import com.example.demo.model.UserAnswers;
import com.example.demo.repository.PollOptionsRepository;
import com.example.demo.repository.PollQuestionRepository;
import com.example.demo.repository.UserRepository;

@RestController
public class QuestionController {
	@Autowired
	PollQuestionRepository questionRepository;
	@Autowired
	PollOptionsRepository optionsRepository;
	@Autowired
	UserAnswersController userAnswersController;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/bulkcreate")
	public String bulkcreate() {
		// save a single Customer
		PollQuestion question = questionRepository.save(new PollQuestion("Which city ? "));
		// save a list of Customers
		PollOption options = new PollOption(question.getId(), "ankara");
		PollOption options2 = new PollOption(question.getId(), "istanbul");
		PollOption options3 = new PollOption(question.getId(), "antepo");
		PollOption options4 = new PollOption(question.getId(), "hastay");

		ArrayList<PollOption> list = new ArrayList<PollOption>();

		list.add(options4);
		list.add(options3);
		list.add(options2);
		list.add(options);

		optionsRepository.saveAll(list);

		return "created";
	}

	@PostMapping("/createQuestion")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public String create(@RequestBody QuestionsWithOptions entry) {
		// save a single Customer
		try {
			PollQuestion addedQuestion = questionRepository.save(new PollQuestion(entry.getQuestion().getQuestionText()));
			List<PollOption> optionsList = entry.getOptionList();
			optionsList.forEach(option -> option.setQuestionId(addedQuestion.getId()));
			optionsRepository.saveAll(optionsList);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "New Questions added";
	}
	
	@PostMapping("/updateQuestion")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public String update(@RequestBody QuestionsWithOptions entry) {
		// save a single Customer
		try {
			questionRepository.deleteById(entry.getQuestion().getId());
			List<PollOption> optionsList = optionsRepository.findByQuestionId(entry.getQuestion().getId());
			optionsList.forEach(option -> optionsRepository.deleteById(option.getId()));
			
			create(entry);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "New Questions added";
	}

	@GetMapping("/getAllQuestions")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public List<QuestionsWithOptions> findAll() {
		List<QuestionsWithOptions> result = new ArrayList<QuestionsWithOptions>();
		List<PollOption> optionList;
		List<PollQuestion> questions = questionRepository.findAll();
		for (PollQuestion pollQuestion : questions) {
			optionList = optionsRepository.findByQuestionId(pollQuestion.getId());
			QuestionsWithOptions questionOptionsToAdd = new QuestionsWithOptions();
			questionOptionsToAdd.setQuestion(pollQuestion);
			questionOptionsToAdd.setOptionList(optionList);
			result.add(questionOptionsToAdd);
		}
		return result;
	}

	@GetMapping("/search/{id}")
	public String search(@PathVariable long id) {
		String question = "";
		question = questionRepository.findById(id).toString();
		return question;
	}

	@GetMapping("/searchbytext/{text}")
	public List<PollQuestion> fetchDataByText(@PathVariable String text) {
		List<PollQuestion> questions = questionRepository.findAll();
		return questions.stream().filter(w -> w.getQuestionText().contains(text)).collect(Collectors.toList());
	}

	@PostMapping("/answerQuestion")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public String answerQuestion(@RequestBody UserAnswers userAnswer) {
		Optional<PollOption> option = optionsRepository.findById(userAnswer.getOptionId());
		optionsRepository.save(option.get().addCount());
		userAnswersController.addUserAnswer(userAnswer);
		return "Question answered";
	}

	@GetMapping("/getUnAnsweredQuestionsByUser/{username}")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public List<QuestionsWithOptions> getUnAnsweredQuestionsByUser(@PathVariable String username) {
		if(username !=null) {
			PollUser user = userRepository.findById(Long.parseLong(username) ).get();
			List<PollQuestion> answeredQuestionListByUser = userAnswersController.getAnsweredQuestionList(user.getId());
			if(answeredQuestionListByUser != null) {
				List<QuestionsWithOptions> result = new ArrayList<QuestionsWithOptions>();
				List<PollOption> optionList;
				List<PollQuestion> questions = questionRepository.findAll();
				for (PollQuestion pollQuestion : questions) {
					if (answeredQuestionListByUser != null && !answeredQuestionListByUser.contains(pollQuestion)) {
						optionList = optionsRepository.findByQuestionId(pollQuestion.getId());
						QuestionsWithOptions questionOptionsToAdd = new QuestionsWithOptions();
						questionOptionsToAdd.setQuestion(pollQuestion);
						questionOptionsToAdd.setOptionList(optionList);
						result.add(questionOptionsToAdd);
					}
						
				}
				return result;
			}
			
		}
		return findAll();
		
	}

	@GetMapping("/getQuestionById/{questionId}")
	public PollQuestion getQuestionById(@PathVariable long questionId) {
		return questionRepository.findById(questionId);
	}
	@Transactional
	@DeleteMapping("/deleteQuestion/{questionId}")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public Boolean deleteQuestion(@PathVariable Long questionId) {
		questionRepository.deleteById(questionId);
		optionsRepository.deleteByQuestionId(questionId);
		return true;
	}

}