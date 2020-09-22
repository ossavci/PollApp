package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PollUser;

public interface UserRepository extends CrudRepository<PollUser, Long>{
	@Query("SELECT u FROM PollUser u WHERE u.username = ?1 and u.password= ?2")
	PollUser login(String username, String password);
	PollUser findByUsernameAndPassword(String username, String password);
	PollUser findByUsername(String username);
	
}
