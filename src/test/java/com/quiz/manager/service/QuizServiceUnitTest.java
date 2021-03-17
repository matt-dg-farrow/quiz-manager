package com.quiz.manager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.quiz.manager.persistence.domain.Answer;
import com.quiz.manager.persistence.domain.Question;
import com.quiz.manager.persistence.domain.Quiz;
import com.quiz.manager.persistence.repo.QuizRepo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuizServiceUnitTest {
    @InjectMocks
    private QuizService quizService;

    @Mock
    private QuizRepo quizRepo;

    private Quiz quiz;
    private Quiz quizUpdate;
    private List<Quiz> quizList;
    private List<Question> questionList;
    private List<Answer> answerList;

    @Before
    public void init() {
        Answer answer = new Answer(1L, "Answer 1", false);
        answerList = new ArrayList<Answer>();
        answerList.add(answer);

        Question question = new Question(1L, "Question 1", answerList);
        questionList = new ArrayList<Question>();
        questionList.add(question);

        quiz = new Quiz(1L, "Quiz 1", questionList);
        quizList = new ArrayList<Quiz>();
        quizList.add(quiz);

        quizUpdate = new Quiz(2L, "Quiz test", questionList);
    }

    @Test
    public void createQuizTest() {
        Mockito.when(quizRepo.save(quiz)).thenReturn(quiz);
        assertEquals(quiz, this.quizService.createQuiz(quiz));
        verify(this.quizRepo, times(1)).save(quiz);
    }

    @Test
    public void findAllQuizzesTest() {
        Mockito.when(quizRepo.findAll()).thenReturn(quizList);
        assertEquals(quizList, this.quizService.findAllQuizzes());
        verify(this.quizRepo, times(1)).findAll();
    }

    @Test
    public void findQuizTest() {
        Mockito.when(quizRepo.getOne(1L)).thenReturn(quiz);
        assertEquals(quiz, this.quizService.findQuiz(1L));
        verify(this.quizRepo, times(1)).getOne(1L);
    }

    @Test
    public void updateQuizTest() {
        Mockito.when(quizRepo.getOne(1L)).thenReturn(quiz);
        Mockito.when(quizRepo.save(quiz)).thenReturn(quiz);
        assertEquals(quiz, this.quizService.updateQuiz(quizUpdate, 1L));
        verify(this.quizRepo, times(1)).save(quiz);
    }

    @Test
    public void deleteQuizTest() {
        this.quizService.deleteQuiz(1L);
        verify(this.quizRepo, times(1)).deleteById(1L);
    }
}
