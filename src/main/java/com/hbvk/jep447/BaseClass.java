package com.hbvk.jep447;

public class BaseClass {
    int value;

    public BaseClass() {
        int i = 3;
        this(i);
    }

    public BaseClass(int value) {
        if (value < 0) throw new RuntimeException();
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
