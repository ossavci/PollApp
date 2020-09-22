package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoginRequest;
import com.example.demo.model.PollUser;
import com.example.demo.repository.UserRepository;

@RestController
public class LoginController {
	@Autowired
	UserRepository repository;

	@PostMapping("/login")
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
	public PollUser login(@RequestBody LoginRequest request) throws Exception {
		PollUser user = repository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		if (null == user) {
			throw new Exception("User not found");
		} 
		return user;
	}

	
}