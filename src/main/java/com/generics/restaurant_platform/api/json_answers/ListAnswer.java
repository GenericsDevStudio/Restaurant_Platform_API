package com.generics.restaurant_platform.api.json_answers;

import java.util.List;

public class ListAnswer<T> extends Answer {
    private List<T> list;

    public ListAnswer(int code, String descritpion, List<T> list) {
        super(code, descritpion);
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
