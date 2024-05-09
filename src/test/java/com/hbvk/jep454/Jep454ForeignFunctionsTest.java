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
}
