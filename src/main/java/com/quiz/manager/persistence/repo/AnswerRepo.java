package com.quiz.manager.persistence.repo;

import com.quiz.manager.persistence.domain.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

}
