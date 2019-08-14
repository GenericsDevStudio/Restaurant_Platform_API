package com.generics.restaurant_platform.api.json_answers;

public class ListAnswer<T> {
    private T[] list;

    public ListAnswer(T... list) {
        this.list = list;
    }

    public T[] getList() {
        return list;
    }
}
