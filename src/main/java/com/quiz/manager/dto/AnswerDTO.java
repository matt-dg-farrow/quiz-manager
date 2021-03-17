package com.quiz.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String text;
    private boolean isCorrect;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
