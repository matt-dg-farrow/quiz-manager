package com.quiz.manager.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.quiz.manager.persistence.domain.Quiz;
import com.quiz.manager.persistence.repo.QuizRepo;

import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private QuizRepo quizRepo;

    public QuizService(QuizRepo quizRepo) {
        super();
        this.quizRepo = quizRepo;
    }

    public Quiz createQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    public List<Quiz> findAllQuizzes() {
        return this.quizRepo.findAll();
    }

    public Quiz findQuiz(Long id) {
        return this.quizRepo.getOne(id);
    }

    public Quiz updateQuiz(Quiz quiz, Long id) {
        Quiz quizToBeUpdated = this.quizRepo.getOne(id);
        quizToBeUpdated.setTitle(quiz.getTitle());
        quizToBeUpdated.setQuestions(quiz.getQuestions());
        return this.quizRepo.save(quizToBeUpdated);
    }

    public void deleteQuiz(Long id) {
        this.quizRepo.deleteById(id);
    }
}
