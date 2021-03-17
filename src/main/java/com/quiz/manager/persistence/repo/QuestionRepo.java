package com.quiz.manager.persistence.repo;

import com.quiz.manager.persistence.domain.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

}