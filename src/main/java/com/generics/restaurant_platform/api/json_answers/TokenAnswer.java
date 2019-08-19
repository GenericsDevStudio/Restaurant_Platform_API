package com.generics.restaurant_platform.api.json_answers;

public class TokenAnswer extends Answer {
    private String token;

    public TokenAnswer(int code, String description, String token) {
        super(code, description);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
