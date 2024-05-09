package com.hbvk.jep454;

import org.junit.jupiter.api.Test;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Jep454ForeignFunctionsTest {

    final Linker linker = Linker.nativeLinker();
    final SymbolLookup stdlib = linker.defaultLookup();

    @Test
    void testCallStrlen() throws Throwable {
        final var helloWorld = "Hello world!";
        MethodHandle strlen = linker
                .downcallHandle(
                        stdlib.find("strlen").orElseThrow(),
                        FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS));
        try (Arena offHeap = Arena.ofConfined()) {
            MemorySegment str = offHeap.allocateFrom(helloWorld);
            assertEquals((long) helloWorld.length(), strlen.invoke(str));
        }
    }

    @Test
    void testCallIslower() throws Throwable {
        MethodHandle islower = linker
                .downcallHandle(
                        stdlib.find("islower").orElseThrow(),
                        FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
        assertEquals(Boolean.TRUE, islower.invoke((int) Character.toLowerCase('l')));
        assertEquals(Boolean.FALSE, islower.invoke((int) Character.toUpperCase('L')));
        assertEquals(Boolean.FALSE, islower.invoke('7'));
    }

    @Test
    void testCallIsdigit() throws Throwable {
        MethodHandle isdigit = linker
                .downcallHandle(
                        stdlib.find("isdigit").orElseThrow(),
                        FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
        assertEquals(Boolean.FALSE, isdigit.invoke((int) Character.toLowerCase('l')));
        assertEquals(Boolean.FALSE, isdigit.invoke((int) Character.toUpperCase('l')));
        assertEquals(Boolean.TRUE, isdigit.invoke('7'));
    }
}
