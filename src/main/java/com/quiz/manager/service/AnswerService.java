package com.quiz.manager.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.quiz.manager.persistence.domain.Answer;
import com.quiz.manager.persistence.repo.AnswerRepo;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private AnswerRepo answerRepo;

    public AnswerService(AnswerRepo answerRepo) {
        super();
        this.answerRepo = answerRepo;
    }

    public Answer createAnswer(Answer answer) {
        return this.answerRepo.save(answer);
    }

    public List<Answer> findAllAnswers() {
        return this.answerRepo.findAll();
    }

    public Answer findAnswer(Long id) {
        return this.answerRepo.getOne(id);
    }

    public Answer updateAnswer(Answer answer, Long id) {
        Answer answerToBeUpdated = this.answerRepo.getOne(id);
        answerToBeUpdated.setText(answer
        .getText());
        answerToBeUpdated.setIsCorrect(answer.getIsCorrect());
        return this.answerRepo.save(answerToBeUpdated);
    }

    public void deleteAnswer(Long id) {
        this.answerRepo.deleteById(id);
    }
}