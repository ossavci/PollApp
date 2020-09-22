package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PollQuestion;

public interface PollQuestionRepository extends CrudRepository<PollQuestion, Long>{
	PollQuestion findById(long id);
	List<PollQuestion> findAll();
	List<PollQuestion> findByQuestionText(String questionText);
}
