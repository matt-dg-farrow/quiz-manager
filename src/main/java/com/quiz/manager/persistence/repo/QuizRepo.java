package com.quiz.manager.persistence.repo;

import com.quiz.manager.persistence.domain.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

}