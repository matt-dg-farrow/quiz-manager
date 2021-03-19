package com.quiz.manager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.quiz.manager.persistence.domain.Answer;
import com.quiz.manager.persistence.repo.AnswerRepo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnswerServiceUnitTest {
    @InjectMocks
    private AnswerService answerService;

    @Mock
    private AnswerRepo answerRepo;

    private Answer answer;
    private Answer answerUpdate;
    private List<Answer> answerList;

    @Before
    public void init() {
        answer = new Answer(1L, "Answer 1", false);
        answerList = new ArrayList<Answer>();
        answerList.add(answer);

        answerUpdate = new Answer(2L, "Answer test", true);
    }

    @Test
    public void createAnswerTest() {
        Mockito.when(answerRepo.save(answer)).thenReturn(answer);
        assertEquals(answer, this.answerService.createAnswer(answer));
        verify(this.answerRepo, times(1)).save(answer);
    }

    @Test
    public void findAllAnswerzesTest() {
        Mockito.when(answerRepo.findAll()).thenReturn(answerList);
        assertEquals(answerList, this.answerService.findAllAnswers());
        verify(this.answerRepo, times(1)).findAll();
    }

    @Test
    public void findAnswerTest() {
        Mockito.when(answerRepo.getOne(1L)).thenReturn(answer);
        assertEquals(answer, this.answerService.findAnswer(1L));
        verify(this.answerRepo, times(1)).getOne(1L);
    }

    @Test
    public void updateAnswerTest() {
        Mockito.when(answerRepo.getOne(1L)).thenReturn(answer);
        Mockito.when(answerRepo.save(answer)).thenReturn(answer);
        assertEquals(answer, this.answerService.updateAnswer(answerUpdate, 1L));
        verify(this.answerRepo, times(1)).save(answer);
    }

    @Test
    public void deleteAnswerTest() {
        this.answerService.deleteAnswer(1L);
        verify(this.answerRepo, times(1)).deleteById(1L);
    }
}
