package com.generics.restaurant_platform.api.json_answers;

public class RegistrationAnswer extends Answer {
    private int id;

    public RegistrationAnswer(int code, String description, int id) {
        super(code, description);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
