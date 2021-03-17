package com.quiz.manager.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.quiz.manager.persistence.domain.Question;
import com.quiz.manager.persistence.repo.QuestionRepo;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        super();
        this.questionRepo = questionRepo;
    }

    public Question createQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    public List<Question> findAllQuestions() {
        return this.questionRepo.findAll();
    }

    public Question findQuestion(Long id) {
        return this.questionRepo.getOne(id);
    }

    public Question updateQuestion(Question question, Long id) {
        Question questionToBeUpdated = this.questionRepo.getOne(id);
        questionToBeUpdated.setTitle(question.getTitle());
        questionToBeUpdated.setAnswers(question.getAnswers());
        return this.questionRepo.save(questionToBeUpdated);
    }

    public void deleteQuestion(Long id) {
        this.questionRepo.deleteById(id);
    }
}
