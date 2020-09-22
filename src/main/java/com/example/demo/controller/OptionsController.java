package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PollOption;
import com.example.demo.repository.PollOptionsRepository;
import com.example.demo.response.BasicResponse;

@RestController
public class OptionsController {
	@Autowired
	PollOptionsRepository repository;

	@PostMapping("/addOption")
	public BasicResponse addOption(@RequestBody PollOption option) {
		repository.save(new PollOption(option.getQuestionId(), option.getOptionText()));
		return new BasicResponse(true, "Option Added");
	}

	@PostMapping("/updateOption")
	public BasicResponse create(@RequestBody PollOption option) {
		Optional<PollOption> optionToUpdate = repository.findById(option.getId());
		repository.save(optionToUpdate.get());
		return new BasicResponse(true, "Option updated");
	}

	@DeleteMapping("/deleteOption/{questionId}")
	public BasicResponse delete(@PathVariable long id) {
		repository.deleteById(id);
		return new BasicResponse(true, "Option deleted");
	}
}