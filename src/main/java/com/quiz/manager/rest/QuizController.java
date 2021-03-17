package com.quiz.manager.rest;

import java.util.ArrayList;
import java.util.List;

import com.quiz.manager.dto.QuizDTO;
import com.quiz.manager.persistence.domain.Question;
import com.quiz.manager.persistence.domain.Quiz;
import com.quiz.manager.service.QuizService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping(path = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class QuizController {
    private QuizService quizService;
    private ModelMapper modelMapper;

    @Autowired
    public QuizController(QuizService quizService, ModelMapper modelMapper) {
        this.quizService = quizService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/create")
    public QuizDTO createQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);

        Quiz storedQuiz = quizService.createQuiz(quiz);

        return modelMapper.map(storedQuiz, QuizDTO.class);
    }

    @GetMapping(path = "/{id}")
    public QuizDTO getQuizById(@PathVariable Long id) {
        return modelMapper.map(quizService.findQuiz(id), QuizDTO.class);
    }

    @GetMapping(path = "/all")
    public List<QuizDTO> getAllQuizzes() {
        return modelMapper.map(quizService.findAllQuizzes(), new TypeToken<List<QuizDTO>>() {
        }.getType());
    }

    @PutMapping(path = "/update")
    public QuizDTO updateQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);

        Quiz updatedQuiz = quizService.updateQuiz(quiz, quiz.getId());

        return modelMapper.map(updatedQuiz, QuizDTO.class);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}
