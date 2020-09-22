package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PollUser;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository repository;

	public String addUser(PollUser user) {
		repository.save(user);
		return "user added";
	}
	

	@GetMapping("getAllUsers")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public Iterable<PollUser> getAllUsers() {
		
		return repository.findAll();
	}
}