package com.hbvk.jep456;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Jep456AnonymousVariableTest {

    @Test
    void loopVariable() {
        int total = 0;
        int[] numbers = {1, 2, 3, 4, 5};
        for (int _ : numbers)
            total++;
        assertEquals(5, total);
    }

    @Test
    void exception() {
        try {
            Integer.parseInt("");
            fail();
        } catch (NumberFormatException _) {
            // ignore
        }
    }

    @Test
    void switchPatternVariables() {
        Object o = this;
        switch (o) {
            case Jep456AnonymousVariableTest _: {
                break;
            }
            case Object _: {
                // Yup, we'll never get here. Just showing that you can use anonymous switch pattern variables ;-)
                fail();
            }
        }
    }

    @Test
    void tryWithResources() throws IOException {
        FileReader fileReader = new FileReader("./pom.xml");
        try (var _ = new BufferedReader(fileReader)) {
            assertTrue(fileReader.ready());
        }
    }

    @Test
    void lambdaParameter() {
        Map<String, String> map = new HashMap<>();
        map.computeIfAbsent("key", _ -> null);
        assertTrue(map.isEmpty());
    }
}
