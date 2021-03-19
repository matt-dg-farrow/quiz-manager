package com.quiz.manager.rest;

import java.util.List;

import com.quiz.manager.dto.QuestionDTO;
import com.quiz.manager.persistence.domain.Question;
import com.quiz.manager.service.QuestionService;

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
@RequestMapping(path = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class QuestionController {
    private QuestionService questionService;
    private ModelMapper modelMapper;

    @Autowired
    public QuestionController(QuestionService questionService, ModelMapper modelMapper) {
        this.questionService = questionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/create")
    public QuestionDTO createQuestion(@RequestBody QuestionDTO questionDTO) {
        Question question = modelMapper.map(questionDTO, Question.class);

        Question storedQuestion = questionService.createQuestion(question);

        return modelMapper.map(storedQuestion, QuestionDTO.class);
    }

    @GetMapping(path = "/{id}")
    public QuestionDTO findQuestionById(@PathVariable Long id) {
        return modelMapper.map(questionService.findQuestion(id), QuestionDTO.class);
    }

    @GetMapping(path = "/all")
    public List<QuestionDTO> findAllQuestions() {
        return modelMapper.map(questionService.findAllQuestions(), new TypeToken<List<QuestionDTO>>() {
        }.getType());
    }

    @PutMapping(path = "/update")
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO questionDTO) {
        Question question = modelMapper.map(questionDTO, Question.class);

        Question updatedQuestion = questionService.updateQuestion(question, question.getId());

        return modelMapper.map(updatedQuestion, QuestionDTO.class);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
