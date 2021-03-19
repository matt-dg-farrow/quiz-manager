package com.quiz.manager.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.manager.persistence.domain.Answer;

public class QuestionDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String title;

    private List<Answer> answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
