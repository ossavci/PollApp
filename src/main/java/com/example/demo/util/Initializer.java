package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.PollOption;
import com.example.demo.repository.PollOptionsRepository;
import com.example.demo.repository.PollQuestionRepository;
import com.example.demo.repository.UserRepository;
@Component
public class Initializer {
	@Autowired
	PollQuestionRepository questionController;
	@Autowired
	PollOptionsRepository optionController;
	@Autowired
	UserRepository userController;
	@Autowired
	public void initialize() {
		addQuestionAndAnswer();
		addUser();
	}

	private void addQuestionAndAnswer() {
//		PollQuestion q1 = new PollQuestion("What is your favorite city ? ");
//		List<PollOption> ol1 = createOptionForQuestion(new String[] { "Cape Town", "Istanbul", "Mumbai", "Bangkok" },
//				questionController.save(q1).getId());
//		optionController.saveAll(ol1);
//
//		q1 = new PollQuestion("Which App you use most ? ");
//		ol1 = createOptionForQuestion(new String[] { "Instagram", "Facebook", "Twitter", "Tiktok" },
//				questionController.save(q1).getId());
//		optionController.saveAll(ol1);
//
//		q1 = new PollQuestion("What is yout favorite club ? ");
//		ol1 = createOptionForQuestion(new String[] { "Man U", "Barca", "Liverpool", "Napoli" },
//				questionController.save(q1).getId());
//		optionController.saveAll(ol1);
//
//		q1 = new PollQuestion("How long have you been use Smartphone ? ");
//		ol1 = createOptionForQuestion(
//				new String[] { "Less than a year", "1 year to less than 3 years", "3 to 5 years", "More than 5 years" },
//				questionController.save(q1).getId());
//		optionController.saveAll(ol1);
//
//		q1 = new PollQuestion("Answer this : 13x2-12? ");
//		ol1 = createOptionForQuestion(new String[] { "130", "-130", "14", "-14" }, questionController.save(q1).getId());
//		optionController.saveAll(ol1);
//
//		q1 = new PollQuestion("Which is the smallest ? ");
//		ol1 = createOptionForQuestion(new String[] { "Turkey", "India", "China", "Russia" },
//				questionController.save(q1).getId());
//		optionController.saveAll(ol1);

	}

	private void addUser() {
//		userController.save(new User("admin", "admin", UserType.ADMIN_USER));
//		userController.save(new User("user1", "user1", UserType.END_USER));
//		userController.save(new User("user2", "user2", UserType.END_USER));
//		userController.save(new User("user3", "user3", UserType.END_USER));
//		userController.save(new User("user4", "user4", UserType.END_USER));
	}

	private List<PollOption> createOptionForQuestion(String[] arr, long questionId) {
		ArrayList<PollOption> optionList = new ArrayList<PollOption>();
		for (String string : arr) {
			optionList.add(new PollOption(questionId, string));
		}
		return optionList;

	}

}
