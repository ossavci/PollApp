package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PollOption;

public interface PollOptionsRepository extends CrudRepository<PollOption, Long>{
	List<PollOption> findByQuestionId(long questionId);
	long deleteByQuestionId(long questionId);
}
