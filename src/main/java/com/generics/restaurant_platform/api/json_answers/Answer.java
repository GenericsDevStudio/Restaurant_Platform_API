package com.generics.restaurant_platform.api.json_answers;

public class Answer {
    private int code;
    private String description;

    public Answer(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
