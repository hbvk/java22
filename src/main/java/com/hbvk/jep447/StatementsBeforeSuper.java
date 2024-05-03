package com.hbvk.jep447;

public class StatementsBeforeSuper extends BaseClass {
    public StatementsBeforeSuper(int value) {
        if (value < 0) throw new RuntimeException();
        super(value);
    }

    public StatementsBeforeSuper() {
        int i = 0;
        super(i);
    }
}


