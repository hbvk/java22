package com.hbvk.jep459;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Jep459StringTemplateTest {
    // NOTE string templates in the current form will probably be removed:
    // https://mail.openjdk.org/pipermail/amber-spec-experts/2024-April/004106.html
    @Test
    void simpleStringTemplate() {
        String greeting = "hello";
        assertEquals("HELLO world!", STR."\{greeting.toUpperCase()} world!");
    }

    @Test
    void anExampleWithSimpleArithmetic(){
        int a = 10;
        int b = 5;
        assertEquals("15", STR."\{a + b}");
    }
}
