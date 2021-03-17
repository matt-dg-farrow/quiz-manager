package com.quiz.manager.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.manager.persistence.domain.Question;

public class QuizDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private List<Question> questions;

    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
