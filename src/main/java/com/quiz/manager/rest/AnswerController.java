package com.quiz.manager.rest;

import java.util.List;

import com.quiz.manager.dto.AnswerDTO;
import com.quiz.manager.persistence.domain.Answer;
import com.quiz.manager.service.AnswerService;

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
@RequestMapping(path = "/answer", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AnswerController {
    private AnswerService answerService;
    private ModelMapper modelMapper;

    @Autowired
    public AnswerController(AnswerService answerService, ModelMapper modelMapper) {
        this.answerService = answerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/create")
    public AnswerDTO createAnswer(@RequestBody AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO, Answer.class);

        Answer storedAnswer = this.answerService.createAnswer(answer);

        return modelMapper.map(storedAnswer, AnswerDTO.class);
    }

    @GetMapping(path = "/{id}")
    public AnswerDTO findAnswerById(@PathVariable Long id) {
        return modelMapper.map(this.answerService.findAnswer(id), AnswerDTO.class);
    }

    @GetMapping(path = "/all")
    public List<AnswerDTO> findAllAnswers() {
        return modelMapper.map(this.answerService.findAllAnswers(), new TypeToken<List<AnswerDTO>>() {
        }.getType());
    }

    @PutMapping(path = "/update")
    public AnswerDTO updateAnswer(@RequestBody AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO, Answer.class);

        Answer updatedAnswer = this.answerService.updateAnswer(answer, answer.getId());

        return modelMapper.map(updatedAnswer, AnswerDTO.class);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        this.answerService.deleteAnswer(id);
    }
}
