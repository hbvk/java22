package com.hbvk.jep447;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Jep447StatementsBeforeSuperTest {

    @Test
    void testStatementsBeforeSuper() {
        StatementsBeforeSuper statementsBeforeSuper = new StatementsBeforeSuper();
        assertEquals(0, statementsBeforeSuper.getValue());
    }

    @Test
    void testStatementsBeforeThis(){
        BaseClass baseClass = new BaseClass();
        assertEquals(3, baseClass.getValue());
    }
}
