package com.quiz.manager.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.quiz.manager.dto.QuizDTO;
import com.quiz.manager.persistence.domain.Answer;
import com.quiz.manager.persistence.domain.Question;
import com.quiz.manager.persistence.domain.Quiz;
import com.quiz.manager.service.QuizService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class QuizControllerUnitTests {
    @InjectMocks
    private QuizController quizController;

    @Mock
    private QuizService quizService;

    @Mock
    private ModelMapper modelMapper;

    private Quiz quiz;
    private Quiz quizUpdate;
    private QuizDTO quizDTO = new QuizDTO();
    private List<QuizDTO> quizList;
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
        quizList = new ArrayList<QuizDTO>();
        // quizList.add(quiz);

        quizDTO.setId(1L);
        quizDTO.setTitle("Quiz 1");
        quizDTO.setQuestions(questionList);

        quizUpdate = new Quiz(2L, "Quiz test", questionList);
    }

    @Test
    public void createQuizTest() {
        Mockito.when(quizService.createQuiz(quiz)).thenReturn(quiz);
        Mockito.when(modelMapper.map(quizDTO, Quiz.class)).thenReturn(quiz);
        // QuizDTO quizDTO = modelMapper.map(quiz, QuizDTO.class);
        // System.out.println(quizDTO.getTitle());
        // assertEquals("one", "one");
        assertEquals(quizDTO, this.quizController.createQuiz(quizDTO));
        verify(this.quizService, times(1)).createQuiz(quiz);
    }

    // @Test
    // public void findAllQuizzesTest() {
    // Mockito.when(quizService.findAllQuizzes()).thenReturn(quizList);
    // assertEquals(quizList, this.quizService.findAllQuizzes());
    // verify(this.quizService, times(1)).findAllQuizzes();
    // }

    // @Test
    // public void findQuizTest() {
    // Mockito.when(quizService.findQuiz(1L)).thenReturn(quiz);
    // assertEquals(quiz, this.quizService.findQuiz(1L));
    // verify(this.quizService, times(1)).findQuiz(1L);
    // }

    // @Test
    // public void updateQuizTest() {
    // Mockito.when(quizService.updateQuiz(quizUpdate, 1L)).thenReturn(quizUpdate);
    // assertEquals(quiz, this.quizService.updateQuiz(quizUpdate, 1L));
    // verify(this.quizService, times(1)).updateQuiz(quizUpdate, 1L);
    // }

    // @Test
    // public void deleteQuizTest() {
    // this.quizService.deleteQuiz(1L);
    // verify(this.quizService, times(1)).deleteQuiz(1L);
    // }
}
