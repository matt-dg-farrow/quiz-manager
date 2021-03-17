package com.quiz.manager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.quiz.manager.persistence.domain.Answer;
import com.quiz.manager.persistence.domain.Question;
import com.quiz.manager.persistence.repo.QuestionRepo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceUnitTest {
    @InjectMocks
    private QuestionService questionService;

    @Mock
    private QuestionRepo questionRepo;

    private Question question;
    private Question questionUpdate;
    private List<Question> questionList;
    private List<Answer> answerList;

    @Before
    public void init() {
        Answer answer = new Answer(1L, "Answer 1", false);
        answerList = new ArrayList<Answer>();
        answerList.add(answer);

        question = new Question(1L, "Question 1", answerList);
        questionList = new ArrayList<Question>();
        questionList.add(question);

        questionUpdate = new Question(2L, "Question test", answerList);
    }

    @Test
    public void createQuestionTest() {
        Mockito.when(questionRepo.save(question)).thenReturn(question);
        assertEquals(question, this.questionService.createQuestion(question));
        verify(this.questionRepo, times(1)).save(question);
    }

    @Test
    public void findAllQuestionzesTest() {
        Mockito.when(questionRepo.findAll()).thenReturn(questionList);
        assertEquals(questionList, this.questionService.findAllQuestions());
        verify(this.questionRepo, times(1)).findAll();
    }

    @Test
    public void findQuestionTest() {
        Mockito.when(questionRepo.getOne(1L)).thenReturn(question);
        assertEquals(question, this.questionService.findQuestion(1L));
        verify(this.questionRepo, times(1)).getOne(1L);
    }

    @Test
    public void updateQuestionTest() {
        Mockito.when(questionRepo.getOne(1L)).thenReturn(question);
        Mockito.when(questionRepo.save(question)).thenReturn(question);
        assertEquals(question, this.questionService.updateQuestion(questionUpdate, 1L));
        verify(this.questionRepo, times(1)).save(question);
    }

    @Test
    public void deleteQuestionTest() {
        this.questionService.deleteQuestion(1L);
        verify(this.questionRepo, times(1)).deleteById(1L);
    }
}
