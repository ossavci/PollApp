package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserAnswers;

public interface UserAnswersRepository extends CrudRepository<UserAnswers, Long>{
	UserAnswers findByUserIdAndQuestionId(long userId,long questionId);
	List<UserAnswers> findByUserId(long userId);
}
